package org.zerowarning.gwt.mdl.components.menus;

import static com.google.gwt.dom.client.Style.Overflow.SCROLL;
import static com.google.gwt.dom.client.Style.Unit.PX;
import static com.google.gwt.event.dom.client.ClickEvent.getType;
import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;

import java.util.ArrayList;
import java.util.List;

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
 * list of items presented in a dialog. It is activated when the associated
 * button is clicked.<br>
 * <br>
 * 
 * When a {@link MenuItem} in the {@link Menu} is clicked, an
 * {@link ItemClickEvent} is sent to the registered {@link ItemClickListener}s.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Menu extends HTMLPanel {

	/**
	 * {@link Menu} main style.
	 */
	public static final String CSS_MDL_MENU = "mdl-menu";

	/**
	 * Bottom Left anchor for the menu.<br>
	 * <br>
	 * 
	 * left side of the menu is aligned with the left side of the action button.
	 * The top of the menu is right below the the bottom edge of the action
	 * button.
	 */
	public static final String ANCHOR_BOTTOM_LEFT = "mdl-menu--bottom-left";

	/**
	 * css flag intended for component upgrade
	 */
	public static final String CSS__JS_MENU = "mdl-js-menu";

	/**
	 * Objects can register themselves to the {@link Menu} to be updated when an
	 * item from the menu is clicked.
	 * 
	 * @author Mohamed Ilyes DIMASSI
	 */
	public static interface ItemClickListener {
		public void onItemClicked(ItemClickEvent event);
	}

	/**
	 * Create the menu component.
	 */
	public Menu(String id) {

		// creating the menu that is a unordered list
		super(UListElement.TAG, "");

		// ... which is activated by the button whose id is
		menuId = id;

		// ...that has the menu selector
		addStyleName(CSS_MDL_MENU);

		// ...that acts like a menu
		addStyleName(CSS__JS_MENU);

		// ...whose items has ripples (for now)
		addStyleName(Ripple.HAS_RIPPLE.toString());

		// ... which is placed below the related button
		addStyleName(ANCHOR_BOTTOM_LEFT);

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
	 * Apply magic to bring the menu to life.<br>
	 * <br>
	 * 
	 * After being attached to the DOM, the {@link Menu} is upgraded using
	 * componentHandler.upgradeElement(element) which in turn uses <a href=
	 * "https://github.com/google/material-design-lite/blob/master/src/menu/menu.
	 * js">MaterialMenu</a> to change the DOM tree of the component and add
	 * required event handlers.<br>
	 * <br>
	 * 
	 * The upgrade process in MaterialMenu requires that the {@link Menu} to be
	 * upgraded is already attached to the menu. MaterialMenu references the
	 * Menu's parent to insert a div between Menu and its parent.<br>
	 * <br>
	 * 
	 * When performing the upgrade MaterialMenu will look for the associated
	 * button in the page DOM to attach the required events to it. That's why,
	 * it is also mandatory that the related action button is attached to the
	 * DOM before {@link Menu}.<br>
	 * <br>
	 * 
	 * 
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
	 * Adds a new option to the list of options of the menu.
	 * 
	 * @param item
	 *            the item to be added.
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

	public void addItemClickListener(ItemClickListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * This method should be extended when additional behavior is required when
	 * {@link MenuItem}s are clicked.
	 * 
	 * @param event
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
	 * this class defines what should happen if the user clicks a menu item
	 * 
	 * @author Mohamed Ilyes DIMASSI
	 *
	 */
	private class ItemClickHandler implements ClickHandler {

		// when a click is detected, first, perform internal routines to keep
		// the component in a consistent state, then broadcast the event its
		// clients in order for them to provide the appropriate actions in
		// response of the Item Click
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

		int height = getElement().getClientHeight();

		if (height > MAX_HEIGHT) {
			getElement().getStyle().setOverflowY(SCROLL);
			getElement().getStyle().setHeight(MAX_HEIGHT, PX);
		}
	}

	/**
	 * all MenuItems are stored here. Useful to find the sequential order of the
	 * selected item
	 */
	protected List<MenuItem> items;

	/**
	 * keep track of handler registration.
	 * 
	 */
	protected List<HandlerRegistration> handlerRegs;

	/**
	 * item click listeners
	 */
	protected List<ItemClickListener> listeners;

	/**
	 * DOM event listener
	 */
	protected ItemClickHandler clickHandler;

	/**
	 * an id that enables the button and the menu to communicate
	 */
	protected String menuId;

	/**
	 * Maximum value not to be exceeded by the menu's height.
	 */
	private static final int MAX_HEIGHT = 200;
}
