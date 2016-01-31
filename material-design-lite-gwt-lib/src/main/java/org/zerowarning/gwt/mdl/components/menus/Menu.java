package org.zerowarning.gwt.mdl.components.menus;

import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;

import java.util.ArrayList;
import java.util.List;

import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
 * {@link ItemClickEvent} is sent
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Menu extends HTMLPanel {

	public static interface ItemClickListener {
		public void onItemClicked(ItemClickEvent event);
	}

	/**
	 * Create a menu and the button controlling the menu.
	 */
	public Menu(String id) {

		// creating the menu that is a unordered list
		super(UListElement.TAG, "");

		// ... which is activated by the button whose id is
		menuId = id;

		// ...that has the menu selector
		addStyleName(CSS_MDL_MENU);

		// ...that acts like a menu
		addStyleName("mdl-js-menu");

		// ...which items has ripples (for now)
		addStyleName(Ripple.HAS_RIPPLE.toString());

		// ... which is placed below the related button
		addStyleName(ANCHOR_BOTTOM_LEFT);

		// set the binding between the menu and the action button
		getElement().setAttribute("for", menuId);

		// create the listener that will handle items selection
		clickHandler = new ItemClickHandler();

		// create the items list
		items = new ArrayList<>();

		// create the array that will hold item click listeners
		listeners = new ArrayList<>();
	}

	public void onLoad() {

		// apply magic to bring the menu to life
		// the upgrade function scan the document looking for the menu in the
		// DOM tree. Therefore the menu should only call this method after it is
		// attached to the DOM.
		upgradeElement(getElement());
	}

	/**
	 * Adds a new option to the list of options of the menu.
	 * 
	 * @param item
	 *            the item to be added.
	 */
	public void addItem(MenuItem item) {
		items.add(item);
		add(item);
		item.addDomHandler(clickHandler, ClickEvent.getType());
	}

	public void addItemClickListener(ItemClickListener listener) {
		this.listeners.add(listener);
	}

	// this class defines what should happen if the user clicks a menu item
	private class ItemClickHandler implements ClickHandler {

		// when a click is detected, first, perform internal routines to keep
		// the component in a consistent state, then broadcast the event its
		// clients in order for them to provide the appropriate actions in
		// response of the Item Click
		@Override
		public void onClick(ClickEvent event) {
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
	}

	// all MenuItems are stored here. Useful to find the sequencial order of the
	// selected item
	private List<MenuItem> items;

	// item click listeners
	private List<ItemClickListener> listeners;

	// DOM event listener
	private ItemClickHandler clickHandler;

	// an id that enables the button and the menu to communicate
	private String menuId;

	// menu main style
	private static final String CSS_MDL_MENU = "mdl-menu";

	// left side of the menu is aligned with the left side of the action button.
	// The top of the menu is right below the the bottom edge of the action
	// button.
	private static final String ANCHOR_BOTTOM_LEFT = "mdl-menu--bottom-left";
}
