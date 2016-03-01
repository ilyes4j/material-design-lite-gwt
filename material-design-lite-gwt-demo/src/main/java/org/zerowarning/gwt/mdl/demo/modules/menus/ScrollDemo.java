package org.zerowarning.gwt.mdl.demo.modules.menus;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.Menu;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Demonstrates the scroll behavior for the menu component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ScrollDemo implements EntryPoint {

  /**
   * Setup a large number of items to activate the scroll behavior.
   */
  @Override
  public void onModuleLoad() {

    final String SCROLL_CONTAINER = "scrollContainer";
    final String BTN_TEXT = "I need a scroll";
    final String COMBO_ID = "menu_scroll_sample";
    final String ITEM_VALUE = "Menu Option #";
    final int ITEM_COUNT = 20;

    RootPanel scrollPanel = get(SCROLL_CONTAINER);

    // setup the action button.
    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);
    btn.getElement().setId(COMBO_ID);
    scrollPanel.add(btn);

    Menu menu = new Menu();
    // prevent the menu from overflowing at the end of the page
    // by setting the anchoring to top
    menu.setAnchor(TOP_LEFT);
    menu.setActionId(COMBO_ID);

    // put many items to force the scroll bar to show up
    for (int i = 0; i < ITEM_COUNT; i++) {
      menu.addItem(ITEM_VALUE + i, true);
    }
    scrollPanel.add(menu);
  }
}
