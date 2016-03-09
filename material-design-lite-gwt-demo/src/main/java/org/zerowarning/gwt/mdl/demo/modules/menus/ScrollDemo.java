package org.zerowarning.gwt.mdl.demo.modules.menus;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.MenuCombo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demonstrates the scroll behavior for the menu component. */
public class ScrollDemo implements EntryPoint {

  /** Setup a large number of items to activate the scroll behavior. */
  public final void onModuleLoad() {

    final int itemCount = 20;

    RootPanel scrollPanel = get("scrollContainer");

    // setup the action button.
    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, "I need a scroll");

    MenuCombo menu = new MenuCombo(btn);
    // prevent the menu from overflowing at the end of the page
    // by setting the anchoring to top
    menu.setAnchor(TOP_LEFT);

    // put many items to force the scroll bar to show up
    for (int i = 0; i < itemCount; i++) {
      menu.addItem("Menu Option #" + i, true);
    }
    scrollPanel.add(menu);
  }
}
