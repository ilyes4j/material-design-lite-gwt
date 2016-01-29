package org.zerowarning.gwt.mdl.components.menus;

import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import java.util.ArrayList;
import java.util.List;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * 
 * A {@link Menu} is a wrapper for the
 * <a href="https://www.getmdl.io/components/index.html#menus-section">
 * MaterialMenu</a> component. It enables the user to select an option from a
 * list of items presented in a dialog that opens with the push of a button.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Menu extends Composite {

	public static interface ItemClickListener {
		public void onItemClicked(ItemClickEvent event);
	}

	/**
	 * Create a menu and the button controlling the menu.
	 */
	public Menu(String text) {

		// creating the component structure;
		panel = new HTMLPanel(SpanElement.TAG, "");

		// create the listener that will handle items selection
		clickHandler = new ItemClickHandler();

		// building an ID for the menu. MDL requires that the button controlling
		// the should have an id. That id is then referenced in the menu
		// component enabling it to communicate with the said button.
		menuId = ATTR_ID + counter;
		// increment the counter to provide a unique id for the next menu to be
		// created
		counter++;

		// create the items list
		items = new ArrayList<>();

		// create the array that will hold item click listeners
		listeners = new ArrayList<>();

		// create the menu layout
		createMenu(text);

		// mandatory when dealing with composites to setup the widget
		initWidget(panel);
	}

	public void onLoad() {

		// apply magic to bring the menu to life
		// the upgrade function scan the document looking for the menu in the
		// DOM tree. Therefore the menu should only call this method after it is
		// attached to the DOM.
		upgradeElement(menu.getElement());
	}

	/**
	 * Adds a new option to the list of options of the menu.
	 * 
	 * @param item
	 *            the item to be added.
	 */
	public void addItem(MenuItem item) {
		items.add(item);
		menu.add(item);
		item.addDomHandler(clickHandler, ClickEvent.getType());
	}

	public void addItemClickListener(ItemClickListener listener) {
		this.listeners.add(listener);
	}

	private void createMenu(String text) {
		// creating the button controlling the menu.
		btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, text);

		// setting a unique id to the button
		btn.getElement().setId(menuId);

		// adding the button to the container
		panel.add(btn);

		// creating the menu that is a unordered list
		menu = new HTMLPanel(UListElement.TAG, "");

		// ...that has the menu selector
		menu.addStyleName(CSS_MDL_MENU);

		// ...that acts like a menu
		menu.addStyleName("mdl-js-menu");

		// ...which items has ripples (for now)
		menu.addStyleName(Ripple.HAS_RIPPLE.toString());

		// ... which is placed below the related button
		menu.addStyleName(ANCHOR_BOTTOM_LEFT);

		// ... which is activated by the button whose id is
		menu.getElement().setAttribute("for", menuId);

		// add the menu to the DOM
		panel.add(menu);
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

	// the button that opens the menu
	private Button btn;

	// the floating menu
	private HTMLPanel menu;

	// the parent panel
	private HTMLPanel panel;

	// an id that enables the button and the menu to communicate
	private String menuId;

	// a counter to generate unique menu identifiers
	private static int counter = 0;

	// a suffix for the generated
	private static final String ATTR_ID = "btn_menu_";

	// menu main style
	private static final String CSS_MDL_MENU = "mdl-menu";

	// left side of the menu is aligned with the left side of the action button.
	// The top of the menu is right below the the bottom edge of the action
	// button.
	private static final String ANCHOR_BOTTOM_LEFT = "mdl-menu--bottom-left";
}
