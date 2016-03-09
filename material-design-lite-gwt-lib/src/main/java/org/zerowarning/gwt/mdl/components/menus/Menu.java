package org.zerowarning.gwt.mdl.components.menus;

import static com.google.gwt.dom.client.Style.Overflow.SCROLL;
import static com.google.gwt.dom.client.Style.Unit.PX;
import static com.google.gwt.event.dom.client.ClickEvent.getType;
import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;
import static org.zerowarning.gwt.mdl.components.MdlGwtUtils.addStyle;
import static org.zerowarning.gwt.mdl.components.MdlGwtUtils.assertIndex;
import static org.zerowarning.gwt.mdl.components.MdlGwtUtils.removeStyle;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_LEFT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.zerowarning.gwt.mdl.components.ComponentHandler;
import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * 
 * A {@link Menu} is a wrapper for the
 * <a href="https://www.getmdl.io/components/index.html#menus-section">
 * MaterialMenu</a> component. It enables the user to select an option from a
 * list of items presented in a dialog. It is activated when its associated
 * button is clicked.<br>
 * <br>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @see Button
 */
public class Menu extends HTMLPanel implements IMenu {

  /**
   * The {@link Menu} material style.
   */
  public static final String CSS_MDL_MENU = "mdl-menu";

  /**
   * css flag intended for component upgrade.
   */
  public static final String CSS_JS_MENU = "mdl-js-menu";

  /**
   * Objects that need to be notified when an {@link MenuItem} is clicked should
   * implement this interface and register themselves to the {@link Menu} using
   * the {@link Menu#addItemClickListener(ItemClickListener)} method. <br>
   * <br>
   * 
   * @author Mohamed Ilyes DIMASSI
   * 
   * @see ItemClickEvent
   */
  public interface ItemClickListener {

    /**
     * {@link ItemClickListener#onItemClicked(ItemClickEvent)} is invoked to
     * perform the appropriate actions in response to the {@link MenuItem}
     * click.
     * 
     * @param event
     *          An event containing the required information on the
     *          {@link MenuItem} that was clicked.
     * 
     */
    void onItemClicked(ItemClickEvent event);
  }

  /**
   * Creates the menu component and associates it with an action button. The
   * link between the {@link Menu} and the action button is established by the
   * id of the button and must be provided using
   * {@link Menu#setActionId(String)}. <br>
   * <br>
   * When the menu is attached to the DOM, it will look for the action button
   * using its id and will decorate it with the appropriate event handlers.
   * 
   * @see Button
   */
  public Menu() {

    // creating the menu that is a unordered list
    super(UListElement.TAG, "");

    LOG.finest("Setting up menu");

    // ... which is placed below the related button
    setAnchor(BOTTOM_LEFT);

    // ...that has the menu selector
    addStyleName(CSS_MDL_MENU);

    // ...that acts like a menu
    addStyleName(CSS_JS_MENU);

    // ...whose items has ripples (for now)
    addStyleName(Ripple.HAS_RIPPLE.toString());

    // create the listener that will handle items selection
    clickHandler = new ItemClickHandler();

    // create the items list
    items = new ArrayList<>();

    // create the handlers references for future listeners removal.
    handlerRegs = new HashMap<>();

    // create the array that will hold item click listeners
    listeners = new ArrayList<>();
  }

  /**
   * Set the id of the related action {@link Button} enabling mdl to bind the
   * {@link Menu} to it. This method can only be invoked when the menu is not
   * already attached to the DOM. If the menu is attached and therefore
   * upgraded, the action button cannot be changed.
   * 
   * @param forId
   *          The id of the action {@link Button}.
   * 
   * @throws IllegalStateException
   *           mdl does not allow re binding the menu when the menu is not yet
   *           upgraded. If the menu is already upgraded an exception is raised.
   */
  public final void setActionId(final String forId)
      throws IllegalStateException {

    // Biding the menu to the button is only possible when the menu is not
    // yet upgraded. If the menu is already upgraded it is not possible to
    // re bind it to another button anymore. mdl does not allow such
    // behavior.
    if (upgraded) {
      StringBuilder sb = new StringBuilder();
      sb.append("The menu is already upgraded !\n");
      sb.append("The menu should be bound to an action ");
      sb.append("button before being upgraded.");

      String msg = sb.toString();

      LOG.warning(msg);

      throw new IllegalStateException(msg);
    }

    // the menu is opened by a button identified by forId
    menuId = forId;

    // set the binding between the menu and the action button
    getElement().setAttribute("for", menuId);
  }

  @Override
  public final void setAnchor(final MenuAnchor inputAnchor) {

    if (upgraded) {

      StringBuilder sb = new StringBuilder();

      sb.append("Attempting to change the anchoring ");
      sb.append("but the menu is already upgraded !\n");
      sb.append("Please set the anchoring for the menu before the upgrade.");

      String msg = sb.toString();

      LOG.warning(msg);

      throw new IllegalStateException(msg);
    }

    // don't do anything if the requested anchor is not defined
    if (inputAnchor == null) {
      return;
    }

    // don't do anything if the requested anchoring is the same anchoring
    // already applied
    if (this.anchor == inputAnchor) {
      return;
    }

    // remove the previously set anchoring
    removeStyle(this, this.anchor);

    // save the requested anchoring
    this.anchor = inputAnchor;

    // use the safe method to set the css selector
    addStyle(this, this.anchor);
  }

  /**
   * Apply magic to bring the menu to life.<br>
   * <br>
   * 
   * After being attached to the DOM, the {@link Menu} is upgraded using
   * {@link ComponentHandler#upgradeElement(com.google.gwt.dom.client.Element)}
   * which in turn uses <a href= "http://tinyurl.com/zbnhayt"> MaterialMenu</a>
   * to change the DOM tree of the component and add the required event
   * handlers.<br>
   * <br>
   * 
   * The upgrade process performed by MaterialMenu requires the {@link Menu} to
   * be already attached to the DOM. This is due to the fact that MaterialMenu
   * references the Menu's parent element during the upgrade.<br>
   * <br>
   * 
   * When performing the upgrade, MaterialMenu will look for the associated
   * button in the page DOM to attach the required events to it. That's why it
   * is also mandatory that the related action button is attached to the DOM
   * before {@link Menu} is.<br>
   * <br>
   */
  @Override
  public final void onLoad() {

    // the menu cannot be upgraded without having a menuId
    if (menuId == null || menuId.isEmpty()) {

      StringBuilder sb = new StringBuilder();

      sb.append("Attempting to upgrade a menu ");
      sb.append("with an undefined action button\n");
      sb.append("Please bind the menu to its action button ");
      sb.append("before attaching it to the DOM.");

      String msg = sb.toString();

      LOG.warning(msg);

      throw new IllegalStateException(msg);
    }

    // transform the menu and apply the needed behaviors
    upgradeElement(getElement());

    LOG.finest("Menu upgraded");

    // mark the component as already upgraded
    upgraded = true;

    // make sure the menu height does not exceed the threshold.
    assertMaxHeight();

    // componentHandler.upgradeElement(element) only operates on the very
    // element it is applied on. It does not operate on inner elements
    // within. Intuitively, the upgrade should be performed on the DOM tree
    // that has element as root but this is not the case. This issue is
    // fixed by upgrading each inner element individually.
    for (MenuItem item : items) {
      upgradeElement(item.getElement());
    }
  }

  @Override
  public final void clearMenu() {

    // remove click handlers
    for (Map.Entry<MenuItem, HandlerRegistration> entry : handlerRegs
        .entrySet()) {
      entry.getValue().removeHandler();
    }

    // reset the handlers registrations list
    handlerRegs.clear();

    // remove items from the DOM
    for (MenuItem item : items) {
      remove(item);
    }

    // reset the item list.
    items.clear();
  }

  @Override
  public final void addItem(final String value, final String text,
      final boolean enabled) {

    // don't let the item be added considering the menu is already upgraded
    if (upgraded) {
      StringBuilder sb = new StringBuilder();

      sb.append("Attempting to add an item to the menu ");
      sb.append("but the menu is already upgraded.\n");
      sb.append("Please add items before the menu is upgraded.");

      String msg = sb.toString();

      LOG.warning(msg);

      throw new IllegalStateException(msg);
    }

    // create the item holder
    MenuItem menuItem = new MenuItem(value, text);

    // ... add it to the items list
    items.add(menuItem);

    // ... add the MenuItem to the DOM.
    add(menuItem);

    // ...set the css style of the item
    menuItem.setEnabled(enabled);

    // set the enabled state for the first time.
    if (enabled) {
      forceEnable(menuItem);
    }
  }

  /**
   * Adds a new item to the menu. The value and the text are set to the same
   * String. Has the same effect as Menu.addItem(item, item , enabled).
   * 
   * @param item
   *          The value and the text of the item to be added
   * 
   * @param enabled
   *          Defines whether the option can be chosen or not.
   */
  public final void addItem(final String item, final boolean enabled) {
    addItem(item, item, enabled);
  }

  /**
   * Has the same effect as Menu.addItem(item , true).
   * 
   * @param item
   *          The value and the text of the item to be added
   */
  public final void addItem(final String item) {
    addItem(item, true);
  }

  /**
   * Shortcut for {@link Menu#addItem(String, boolean)} that adds an enabled
   * item to the menu.
   * 
   * @param value
   *          the value of the item to be added.
   * 
   * @param text
   *          the text of the item to be added.
   */
  public final void addItem(final String value, final String text) {
    addItem(value, text, true);
  }

  @Override
  public final void addItemClickListener(final ItemClickListener listener) {
    this.listeners.add(listener);
  }

  @Override
  public final int size() {
    return items.size();
  }

  @Override
  public final String getItemText(final int index) {

    return getMenuItem(index).getText();
  }

  @Override
  public final String getValue(final int index) {
    return getMenuItem(index).getValue();
  }

  @Override
  public final boolean setEnabled(final int index, final boolean enabled) {

    // retrieve the item from index
    MenuItem item = getMenuItem(index);

    // set the enabled state of the item
    return setEnabled(item, enabled);
  }

  @Override
  public final boolean isEnabled(final int index) {
    return getMenuItem(index).isEnabled();
  }

  /**
   * This method should be extended when additional behavior is required.
   * 
   * @param event
   *          The browser click event.
   */
  protected void afterItemClicked(final ClickEvent event) {
  }

  /**
   * 
   * @param event
   *          The browser click event.
   * 
   */
  private void itemClicked(final ClickEvent event) {
    // get the sender of the click event
    Object source = event.getSource();

    // is the sender one of the items of the menu
    if (source instanceof MenuItem) {

      // cast the sender into a MenuItem
      MenuItem itemSrc = (MenuItem) source;

      // the sequential order of the item in the list of items
      int itemIndex = items.indexOf(itemSrc);
      String itemValue = itemSrc.getText();

      // create the event containing the required informations about
      // the selected item
      ItemClickEvent evt = new ItemClickEvent(itemIndex, itemValue);

      // dispatch the selected item to all listeners
      for (ItemClickListener listener : listeners) {
        listener.onItemClicked(evt);
      }

      afterItemClicked(event);
    }
  }

  /**
   * Support for {@link Menu#setEnabled(int, boolean)}.
   * 
   * @param item
   *          the item in the item list of the menu
   * 
   * @param enabled
   *          the state to be set for the item
   * 
   * @return <code>true</code> if the state was modified, <code>false</code>
   *         otherwise.
   */
  private boolean setEnabled(final MenuItem item, final boolean enabled) {

    // if the state of the element did not change then do nothing and return
    // false
    if (!item.setEnabled(enabled)) {
      return false;
    }

    // after making sure the item state was toggled, the registration of the
    // click event can be handled safely.

    // if the item is gone from disabled to enabled then add a click
    // listener
    if (enabled) {

      forceEnable(item);

    } else {
      // otherwise the item must have gone from enabled to disabled then,
      // remove the previously positioned click listener

      forceDisable(item);
    }

    // return true, meaning that the item state was toggled
    return true;
  }

  /**
   * Sets the state of the item regardless of its previous state. This is
   * normally done when the item is initialized and added to the menu.
   * 
   * @param item
   *          the item to be enabled
   */
  private void forceEnable(final MenuItem item) {

    // the click handler registration object
    HandlerRegistration reg;

    // register the click handler to the item
    reg = item.addDomHandler(clickHandler, getType());

    // store the association between the item and its listener
    handlerRegs.put(item, reg);

  }

  /**
   * Sets the state of the item regardless of its previous state. This is a
   * utility method to support {@link Menu#setEnabled(int, boolean)}
   * 
   * @param item
   *          the item to be enabled
   */
  private void forceDisable(final MenuItem item) {

    // the click handler registration object
    HandlerRegistration reg;

    // get the click handler from the item
    reg = handlerRegs.get(item);

    // do not listen to click events coming from this item
    reg.removeHandler();

    // remove the broken association from the map
    handlerRegs.remove(item);
  }

  /**
   * Returns a {@link MenuItem} provided its sequential position in the
   * {@link Menu}. Makes sure the item is within the boundaries of the list
   * otherwise throws an {@link ArrayIndexOutOfBoundsException}.
   * 
   * @param index
   *          the position of the item in the Menu.
   * 
   * @return the item.
   * 
   * @throws ArrayIndexOutOfBoundsException
   *           if the index is ouside the boundaries of the items list.
   */
  private MenuItem getMenuItem(final int index) {

    assertIndex(size(), index);

    return items.get(index);
  }

  /**
   * this class defines the internal processing that should be performed when a
   * browser click event related to a {@link MenuItem} is received.
   * 
   * @author Mohamed Ilyes DIMASSI
   *
   */
  private class ItemClickHandler implements ClickHandler {

    /**
     * when a click is detected, first, perform internal actions to keep the
     * component in a consistent state, then broadcast the event to the menu's
     * listeners in order for them to provide the appropriate actions in
     * response of the {@link MenuItem} click.
     * 
     * @param event
     *          The click event emitted by the browser.
     */
    @Override
    public void onClick(final ClickEvent event) {
      itemClicked(event);
    }
  }

  /**
   * If the menu approximate height exceeds the max threshold, add a scroll bar.
   */
  private void assertMaxHeight() {

    // the value returned accounts for the padding value, but the enforced
    // height does not account for any paddings. The resulting height of the
    // menu is the max height to which is added the top and bottom paddings.
    // This result is only problematic when absurdly large paddings are used
    // which is very unlikely to happen. When reasonable padding values are
    // used, the overall height stays within the range of the threshold.
    int height = getElement().getClientHeight();

    if (height > MAX_HEIGHT) {
      getElement().getStyle().setOverflowY(SCROLL);
      getElement().getStyle().setHeight(MAX_HEIGHT, PX);
    }
  }

  /**
   * Setter for the items list.
   * 
   * @param itemList
   *          the menu item list.
   */
  protected final void setItems(final List<MenuItem> itemList) {
    this.items = itemList;
  }

  /**
   * Getter for the items list.
   * 
   * @return the menu item list.
   */
  protected final List<MenuItem> getItems() {
    return this.items;
  }

  /**
   * All {@link MenuItem}s are stored in this list to be able to find the
   * sequential order of the selected item afterwards.
   */
  private List<MenuItem> items;

  /**
   * Keeps track of handlers registration to make removing the handlers possible
   * later.
   */
  private Map<MenuItem, HandlerRegistration> handlerRegs;

  /**
   * The list of all objects waiting to be notified when a {@link MenuItem} is
   * clicked.
   */
  private List<ItemClickListener> listeners;

  /**
   * DOM click event listener.
   */
  private ItemClickHandler clickHandler;

  /**
   * An id that enables the button and the menu to be linked.
   */
  private String menuId;

  /**
   * Stores the menu anchor option to ease the css selector removal.
   */
  private MenuAnchor anchor;

  /**
   * store the status of the component to indicate whether the component is
   * already upgraded.
   */
  private boolean upgraded = false;

  /**
   * Default maximum value not to be exceeded by the menu's height.
   */
  private static final int MAX_HEIGHT = 200;

  /**
   * Menu logger.
   */
  private static final Logger LOG = Logger.getLogger(Menu.class.getName());
}
