package com.github.ilyes4j.gwt.mdl.components.menus;

import static com.github.ilyes4j.gwt.mdl.components.ComponentHandler.upgradeElement;
import static com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils.assertIndex;
import static com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor.BOTTOM_LEFT;
import static com.google.gwt.dom.client.Style.Overflow.SCROLL;
import static com.google.gwt.dom.client.Style.Unit.PX;
import static com.google.gwt.event.dom.client.ClickEvent.getType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.ripples.RippleSwitcher;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
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
public class Menu extends HTMLPanel implements IMenu, IHasEventSource {

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

    // setup the anchor css switcher
    anchor = new MenuAnchorSwitcher();
    anchor.setTarget(getElement());
    anchor.setValue(MenuAnchor.BOTTOM_LEFT);

    LOG.finest("Setting up menu");

    // ... which is placed below the related button
    setAnchor(BOTTOM_LEFT);

    // ...that has the menu selector
    addStyleName(CSS_MDL_MENU);

    // ...that acts like a menu
    addStyleName(CSS_JS_MENU);

    // ...whose items has ripples (for now)
    ripple = new RippleSwitcher();
    ripple.setTarget(getElement());
    ripple.setValue(Ripple.HAS_RIPPLE);

    // create the listener that will handle items selection
    clickHandler = new ItemClickHandler();

    // create the items list
    items = new ArrayList<>();

    // create the handlers references for future listeners removal.
    handlerRegs = new HashMap<>();

    // create the array that will hold item click listeners
    listeners = new ArrayList<>();

    // set the event sender as the the menu by default
    source = this;
  }

  @Override
  public void setEventSource(final Object inputSource) {
    this.source = inputSource;
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
    MdlGwtUtils.setFor(getElement(), menuId);
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

    anchor.setValue(inputAnchor);
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
    assertHeight();

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
    for (HandlerRegistration handler : handlerRegs.values()) {
      handler.removeHandler();
    }

    // reset the handlers registrations list
    handlerRegs.clear();

    // unplug listeners and remove the items from the DOM
    for (MenuItem item : items) {

      downgradeItem(item);

      // detach the item from its parent
      remove(item);
    }

    // reset the item list.
    items.clear();

    // remove the scroll bar considering that the menu is now empty
    assertHeight();
  }

  @Override
  public final void addItem(final String text, final String value,
      final boolean enabled) {

    addItem(text, value, getItemCount(), enabled);
  }

  @Override
  public void addItem(final String text, final String value, final int position,
      final boolean enabled) {
    // create the item holder
    MenuItem menuItem = new MenuItem(value, text);

    // ... add it to the items list
    items.add(position, menuItem);

    // ... add the MenuItem to the DOM.
    insert(menuItem, (Element) getElement(), position, true);

    // ...set the css style of the item
    menuItem.setEnabled(enabled);

    // set the enabled state for the first time.
    if (enabled) {
      forceEnable(menuItem);
    }

    if (upgraded) {
      prepareAddItem(getElement(), menuItem.getElement());
      assertHeight();
      ComponentHandler.upgradeElement(menuItem.getElement());
    }
  }

  @Override
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
  public final int getItemCount() {
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

  @Override
  public void removeItem(final int index) {

    // don't do anything if the item is out of range
    if (index < 0 || index >= items.size()) {
      return;
    }

    // retrieve the item
    MenuItem item = items.get(index);

    downgradeItem(item);

    // remove click handler if registered
    if (item.isEnabled()) {
      forceDisable(item);
    }

    // remove from the list of items
    items.remove(index);

    // remove from the DOM
    remove(item);

    // decide whether a scroll is needed now that an item is removed
    assertHeight();
  }

  /**
   * unplug event handlers and downgrade only if the menu is upgraded.
   * 
   * @param item
   *          the menu item to be downgraded
   */
  private void downgradeItem(final MenuItem item) {
    if (upgraded) {
      // clean up the item from event handlers
      destroyItem(getElement(), item.getElement());

      // remove the component controller from the registry of mdl components
      ComponentHandler.downgradeElement(item.getElement());
    }
  }

  /**
   * Prepare the menu item for removal by unregistering event listeners.
   * 
   * @param menu
   *          the menu from which the item will be removed
   * 
   * @param item
   *          the item to be removed
   * 
   */
  private native void destroyItem(final Element menu, final Element item)
  /*-{
    //retrieve the menu element
    var matMenu = menu.MaterialMenu;
  
    // remove the listener from the item.
    item.removeEventListener('click', matMenu.boundItemClick_);
    // Add a keyboard listener to each menu item.
    item.removeEventListener('keydown', matMenu.boundItemKeydown_);
  }-*/;

  /**
   * On upgrade, the menu applies some transformations on the items like adding
   * a ripple container. In order for the item added after upgrade to benefit
   * from the same feature and be treated consistently, these operations are
   * DUPLICATED in this method. Obviously, there is a maintenance issue with
   * this solution, but there is no other option for the moment. In this
   * situation, the native implementation should be monitored for changes and
   * these changes should be applied to enforce consistency over time.
   * 
   * @param menu
   *          the menu DOM node
   * 
   * @param item
   *          the item DOM node
   */
  private native void prepareAddItem(final Element menu, final Element item)
  /*-{
  
    var matMenu = menu.MaterialMenu;
  
    // Add a listener to each menu item.
    item.addEventListener('click', matMenu.boundItemClick_);
    // Add a tab index to each menu item.
    item.tabIndex = '-1';
    // Add a keyboard listener to each menu item.
    item.addEventListener('keydown', matMenu.boundItemKeydown_);
  
    // Add ripple classes to each item, if the user has enabled ripples.
    if (menu.classList.contains(matMenu.CssClasses_.RIPPLE_EFFECT)) {
  
      var rippleContainer = document.createElement('span');
      rippleContainer.classList
          .add(matMenu.CssClasses_.ITEM_RIPPLE_CONTAINER);
  
      var ripple = document.createElement('span');
      ripple.classList.add(matMenu.CssClasses_.RIPPLE);
      rippleContainer.appendChild(ripple);
      item.appendChild(rippleContainer);
  
      item.classList.add(matMenu.CssClasses_.RIPPLE_EFFECT);
    }
    
  }-*/;

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
    Object clickSource = event.getSource();

    // is the sender one of the items of the menu
    if (clickSource instanceof MenuItem) {

      // cast the sender into a MenuItem
      MenuItem itemSrc = (MenuItem) clickSource;

      // the sequential order of the item in the list of items
      int itemIndex = items.indexOf(itemSrc);
      String itemValue = itemSrc.getText();

      // create the event containing the required informations about
      // the selected item
      ItemClickEvent evt = new ItemClickEvent(itemIndex, itemValue, source);

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

    assertIndex(getItemCount(), index);

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
   * If the menu contains more than {@link Menu#MAX_ITEMS} number of items than
   * add a scroll bar to the menu.
   */
  private void assertHeight() {

    // The previously implemented solution to determine when a scroll bar is
    // required was to measure the height of the menu. If the height exceeds
    // the threshold then a scroll bar is added.
    //
    // The problem with this solution is that when the scroll bar is added, the
    // height cannot anymore be used to determine if the scroll bar is still
    // needed. In fact even if the number of items decreases below the threshold
    // the fixed height and scroll will prevent the menu from shrinking.
    //
    // In order to be able to determine if the scroll needs to be removed it has
    // to be set to a neutral situation without a scroll bar before challenging
    // the height of the menu.
    //
    // Another problem faced with the height solution is that the height is not
    // calculated when the container is invisible. In this scenario it becomes
    // more difficult to determine when the height value has a meaningful
    // value in addition to also knowing when the value will become meaningful.
    //
    // with the present solution, the number of items added to the menu is used
    // to determine whether the menu requires a scroll bar.
    if (getItemCount() > MAX_ITEMS) {
      getElement().getStyle().setOverflowY(SCROLL);
      getElement().getStyle().setHeight(MAX_HEIGHT, PX);
    } else {
      getElement().getStyle().setOverflowY(Overflow.AUTO);
      getElement().getStyle().setProperty("height", "auto");
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
   * Help switch between ripple states.
   */
  private RippleSwitcher ripple;

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
  private MenuAnchorSwitcher anchor;

  /**
   * store the status of the component to indicate whether the component is
   * already upgraded.
   */
  private boolean upgraded = false;

  /**
   * Default maximum value not to be exceeded by the menu's height.
   */
  private static final int MAX_HEIGHT = 208;

  /**
   * The maximum amount of items to show before adding a scroll bar.
   */
  private static final int MAX_ITEMS = 4;

  /**
   * The {@link Menu} material style.
   */
  private static final String CSS_MDL_MENU = "mdl-menu";

  /**
   * css flag intended for component upgrade.
   */
  private static final String CSS_JS_MENU = "mdl-js-menu";

  /**
   * Stores the source of published events.
   */
  private Object source;

  /**
   * Menu logger.
   */
  private static final Logger LOG = Logger.getLogger(Menu.class.getName());
}
