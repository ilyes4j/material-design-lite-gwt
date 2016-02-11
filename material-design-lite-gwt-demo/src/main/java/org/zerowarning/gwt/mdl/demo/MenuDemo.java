package org.zerowarning.gwt.mdl.demo;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createIcon;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_LEFT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_RIGHT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_RIGHT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.ItemClickEvent;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.components.menus.MenuAnchor;
import org.zerowarning.gwt.mdl.components.menus.MenuCombo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Mohamed Ilyes DIMASSI
 */
public class MenuDemo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// add the anchor variations demo
		anchorDemo();

		eventClickDemo();
		menusScrollDemo();
	}

	/**
	 * Setup the four possible anchoring variations for the {@link Menu} and add
	 * them to the page.
	 */
	private void anchorDemo() {

		// create a MenuCombo anchored to the left bottom corner of its action
		// button then add it to its container
		get("ctnr_01").add(createCombo(BOTTOM_LEFT));

		// create a MenuCombo anchored to the right bottom corner of its action
		// button then add it to its container
		get("ctnr_02").add(createCombo(BOTTOM_RIGHT));

		// create a MenuCombo anchored to the left top corner of its action
		// button then add it to its container
		get("ctnr_03").add(createCombo(TOP_LEFT));

		// create a MenuCombo anchored to the right top corner of its action
		// button then add it to its container
		get("ctnr_04").add(createCombo(TOP_RIGHT));
	}

	/**
	 * Helper method that sets up a template {@link MenuCombo}. The anchor
	 * option is left unspecified to be provided from above.
	 * 
	 * @param anchor
	 *            Determines how the created {@link MenuCombo} is positioned
	 *            compared to its associated {@link Button}
	 * 
	 * @return an instance of {@link MenuCombo} that is anchored according to
	 *         the input {@link MenuAnchor}.
	 */
	private MenuCombo createCombo(MenuAnchor anchor) {

		// setup the action button
		Button btn = createIcon(BTN_NO_COLOR, NONE, "more_vert");

		// setup the menu and its items
		Menu menu = new Menu();

		menu.setAnchor(anchor);

		// add some options to the menu
		menu.addItem("Some action", true);
		menu.addItem("Another action", true);
		menu.addItem("Yet another action", true);

		// wrap the menu and the action button inside a combo
		return new MenuCombo(menu, btn);
	}

	private void eventClickDemo() {

		final String EVENT_CONTAINER = "eventContainer";
		final String COMBO_ID = "menu_event_sample";
		final String BTN_TEXT = "Choose option";
		final String ITEM_VALUE = "I choose Option #";

		RootPanel eventPanel = get(EVENT_CONTAINER);

		Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);
		btn.getElement().setId(COMBO_ID);
		eventPanel.add(btn);

		Menu menu = new Menu();
		menu.setActionId(COMBO_ID);
		menu.addItem(ITEM_VALUE + "1", true);
		menu.addItem(ITEM_VALUE + "2", false);
		menu.addItem(ITEM_VALUE + "3", true);
		eventPanel.add(menu);

		final Label lbl = new Label();
		lbl.setText("Choose option");
		lbl.addStyleName("mdl-typography--title");
		lbl.addStyleName("mdl-gwt-select-status");
		eventPanel.add(lbl);

		menu.addItemClickListener(new Menu.ItemClickListener() {

			@Override
			public void onItemClicked(ItemClickEvent event) {
				lbl.setText(event.getValue());
			}
		});
	}

	private void menusScrollDemo() {
		final String SCROLL_CONTAINER = "scrollContainer";
		final String BTN_TEXT = "I need a scroll";
		final String COMBO_ID = "menu_scroll_sample";
		final String ITEM_VALUE = "Menu Option #";

		RootPanel eventPanel = RootPanel.get(SCROLL_CONTAINER);

		Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);
		btn.getElement().setId(COMBO_ID);
		eventPanel.add(btn);

		Menu menu = new Menu();
		menu.setActionId(COMBO_ID);
		for (int i = 0; i < 20; i++) {
			menu.addItem(ITEM_VALUE + i, true);
		}
		eventPanel.add(menu);
	}
}