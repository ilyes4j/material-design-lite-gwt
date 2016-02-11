package org.zerowarning.gwt.mdl.components.menus;

import static com.google.gwt.dom.client.Style.Overflow.SCROLL;
import static com.google.gwt.dom.client.Style.Unit.PX;
import static com.google.gwt.event.dom.client.ClickEvent.getType;
import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;
import static org.zerowarning.gwt.mdl.components.MdlGwtUtils.addStyle;
import static org.zerowarning.gwt.mdl.components.MdlGwtUtils.removeStyle;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_LEFT;

import java.util.ArrayList;
import java.util.List;

import org.zerowarning.gwt.mdl.components.ComponentHandler;
import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Anchor;
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
public class Menu extends HTMLPanel {

	/**
	 * The {@link Menu} material style.
	 */
	public static final String CSS_MDL_MENU = "mdl-menu";

	/**
	 * css flag intended for component upgrade.
	 */
	public static final String CSS__JS_MENU = "mdl-js-menu";

	/**
	 * Objects that need to be notified when an {@link MenuItem} is clicked
	 * should implement this interface and register themselves to the
	 * {@link Menu} using the
	 * {@link Menu#addItemClickListener(ItemClickListener)} method. <br>
	 * <br>
	 * 
	 * @author Mohamed Ilyes DIMASSI
	 * 
	 * @see {@link ItemClickEvent}
	 */
	public static interface ItemClickListener {

		/**
		 * {@link ItemClickListener#onItemClicked(ItemClickEvent)} is invoked to
		 * perform the appropriate actions in response to the {@link MenuItem}
		 * click.
		 * 
		 * @param event
		 *            An event containing the required information on the
		 *            {@link MenuItem} that was clicked.
		 * 
		 */
		public void onItemClicked(ItemClickEvent event);
	}

	/**
	 * Creates the menu component and associates it with an action button. The
	 * link between the {@link Menu} and the action button is established by the
	 * id of the button and must be provided in the {@link Menu} constructor.
	 * <br>
	 * <br>
	 * When the menu is created, it will look for the action button using its id
	 * and will decorate it with the appropriate event handlers.
	 * 
	 * @param id
	 *            the id of the associated action button.
	 * 
	 * @see Button
	 */
	public Menu(String id) {

		// creating the menu that is a unordered list
		super(UListElement.TAG, "");

		// ... which is activated by the button whose id is
		menuId = id;

		// ... which is placed below the related button
		setAnchor(BOTTOM_LEFT);

		// ...that has the menu selector
		addStyleName(CSS_MDL_MENU);

		// ...that acts like a menu
		addStyleName(CSS__JS_MENU);

		// ...whose items has ripples (for now)
		addStyleName(Ripple.HAS_RIPPLE.toString());

		// set the binding between the menu and the action button
		getElement().setAttribute("for", menuId);

		// create the listener that will handle items selection
		clickHandler = new ItemClickHandler();

		// create the items list
		items = new ArrayList<>();

		// create the handlers references for future listeners removal.
		handlerRegs = new ArrayList<>();

		// create the array that will hold item click listeners
		listeners = new ArrayList<>();
	}

	/**
	 * Sets the position of the {@link Menu} on the screen related to its
	 * associated action button using one of the available anchoring options
	 * provided by {@link MenuAnchor}.<br>
	 * <br>
	 * 
	 * An extra care should be taken when anchoring the menu. According to this
	 * <a href="https://github.com/google/material-design-lite/issues/952">
	 * thread</a>, the menu's parent need a position:relative in order for the
	 * menu to be anchored correctly.
	 * 
	 * @param anchor
	 *            the requested {@link Anchor} position for the {@link Menu} .
	 */
	public void setAnchor(MenuAnchor anchor) {

		// don't do anything if the requested anchor is not defined
		if (anchor == null) {
			return;
		}

		// don't do anything if the requested anchoring is the same anchoring
		// already applied
		if (this.anchor == anchor) {
			return;
		}

		// remove the previously set anchoring
		removeStyle(this, this.anchor);

		// save the requested anchoring
		this.anchor = anchor;

		// use the safe method to set the css selector
		addStyle(this, this.anchor);
	}

	/**
	 * Apply magic to bring the menu to life.<br>
	 * <br>
	 * 
	 * After being attached to the DOM, the {@link Menu} is upgraded using
	 * {@link ComponentHandler#upgradeElement(com.google.gwt.dom.client.Element)}
	 * which in turn uses <a href=
	 * "https://github.com/google/material-design-lite/blob/master/src/menu/menu.
	 * js">MaterialMenu</a> to change the DOM tree of the component and add the
	 * required event handlers.<br>
	 * <br>
	 * 
	 * The upgrade process performed by MaterialMenu requires the {@link Menu}
	 * to be already attached to the DOM. This is due to the fact that
	 * MaterialMenu references the Menu's parent element during the upgrade.<br>
	 * <br>
	 * 
	 * When performing the upgrade, MaterialMenu will look for the associated
	 * button in the page DOM to attach the required events to it. That's why it
	 * is also mandatory that the related action button is attached to the DOM
	 * before {@link Menu} is.<br>
	 * <br>
	 */
	@Override
	public void onLoad() {

		upgradeElement(getElement());

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

	/**
	 * Remove all items from the menu.
	 */
	public void clearMenu() {

		// remove click handlers
		for (HandlerRegistration reg : handlerRegs) {
			reg.removeHandler();
		}
		handlerRegs.clear(); // reset the handlers registrations list

		// remove items from the DOM
		for (MenuItem item : items) {
			remove(item);
		}
		items.clear(); // reset the item list.
	}

	/**
	 * Adds a new option to the list of options in the menu.
	 * 
	 * @param item
	 *            The item to be added.
	 * 
	 * @param enabled
	 *            Defines whether the option can be chosen or not.
	 */
	public void addItem(String item, boolean enabled) {
		HandlerRegistration reg;

		// create the item holder
		MenuItem menuItem = new MenuItem(item);

		menuItem.setEnabled(enabled);

		// ... add it the items list
		items.add(menuItem);
		// ... add the MenuItem to the DOM.
		add(menuItem);

		// register a click handler for the item only if the item is enabled.
		// keep the handler reference
		if (enabled) {
			reg = menuItem.addDomHandler(clickHandler, getType());
			handlerRegs.add(reg);
		}
	}

	/**
	 * When an object needs to be notified upon a {@link MenuItem} click, it
	 * must be be registered to the {@link Menu} as an {@link ItemClickListener}
	 * .<br>
	 * <br>
	 * In order to receive item click notifications, the object should :
	 * <ol>
	 * <li>Implement the {@link ItemClickListener} interface</li>
	 * <li>Define the actions that should be performed when a {@link MenuItem}
	 * is clicked inside {@link ItemClickListener#onItemClicked(ItemClickEvent)}
	 * </li>
	 * <li>Call {@link Menu#addItemClickListener(ItemClickListener)} to register
	 * itself to the menu and receive click notifications</li>
	 * </ol>
	 * 
	 * @param listener
	 *            The object to be notified when a {@link MenuItem} is clicked.
	 * 
	 * @see ItemClickListener
	 */
	public void addItemClickListener(ItemClickListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * This method should be extended when additional behavior is required.
	 * 
	 * @param event
	 *            The browser click event.
	 * 
	 */
	protected void itemClicked(ClickEvent event) {
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
		}
	}

	/**
	 * this class defines the internal processing that should be performed when
	 * a browser click event related to a {@link MenuItem} is received.
	 * 
	 * @author Mohamed Ilyes DIMASSI
	 *
	 */
	private class ItemClickHandler implements ClickHandler {

		/**
		 * when a click is detected, first, perform internal actions to keep the
		 * component in a consistent state, then broadcast the event to the
		 * menu's listeners in order for them to provide the appropriate actions
		 * in response of the {@link MenuItem} click.
		 * 
		 * @param event
		 *            The click event emitted by the browser.
		 */
		@Override
		public void onClick(ClickEvent event) {
			itemClicked(event);
		}
	}

	/**
	 * If the menu approximate height exceeds the max threshold, add a scroll
	 * bar.
	 */
	private void assertMaxHeight() {

		// the value returned accounts for the padding value, but the enforced
		// height does not account for any paddings. This results in the This is not an
		// issue since the intended behavior is to not exceed a maximum
		// threshold not set an exact height value for the menu.
		int height = getElement().getClientHeight();

		if (height > MAX_HEIGHT) {
			getElement().getStyle().setOverflowY(SCROLL);
			getElement().getStyle().setHeight(MAX_HEIGHT, PX);
		}
	}

	/**
	 * All {@link MenuItem}s are stored in this list to be able to find the
	 * sequential order of the selected item afterwards.
	 */
	protected List<MenuItem> items;

	/**
	 * Keeps track of handlers registration to make removing the handlers
	 * possible later.
	 */
	protected List<HandlerRegistration> handlerRegs;

	/**
	 * The list of all objects waiting to be notified when a {@link MenuItem} is
	 * clicked.
	 */
	protected List<ItemClickListener> listeners;

	/**
	 * DOM click event listener.
	 */
	protected ItemClickHandler clickHandler;

	/**
	 * An id that enables the button and the menu to be linked.
	 */
	protected String menuId;

	/**
	 * Stores the menu anchor option to ease the css selector removal.
	 */
	protected MenuAnchor anchor;

	/**
	 * Default maximum value not to be exceeded by the menu's height.
	 */
	private static final int MAX_HEIGHT = 200;
}
