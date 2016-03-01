package org.zerowarning.gwt.mdl.demo.modules.menus;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createIcon;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_LEFT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.BOTTOM_RIGHT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_RIGHT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.components.menus.MenuAnchor;
import org.zerowarning.gwt.mdl.components.menus.MenuCombo;

import com.google.gwt.core.client.EntryPoint;

/**
 * Demonstrates the anchoring alternatives made possible for the menu component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class AnchorDemo implements EntryPoint {

  /**
   * Setup the four possible anchoring variations for the {@link Menu} and add
   * them to the page.
   */
  @Override
  public void onModuleLoad() {

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
   * Helper method that sets up a template {@link MenuCombo}. The anchor option
   * is left unspecified to be provided from above.
   * 
   * @param anchor
   *          Determines how the created {@link MenuCombo} is positioned
   *          compared to its associated {@link Button}
   * 
   * @return an instance of {@link MenuCombo} that is anchored according to the
   *         input {@link MenuAnchor}.
   */
  private MenuCombo createCombo(MenuAnchor anchor) {

    // setup the action button
    Button btn = createIcon(BTN_NO_COLOR, NONE, "more_vert");

    // setup the menu and its items
    MenuCombo menu = new MenuCombo(btn);

    //position the menu related to the action button
    menu.setAnchor(anchor);

    // add some options to the menu
    menu.addItem("Some action", true);
    menu.addItem("Another action", true);
    menu.addItem("Yet another action", true);

    return menu;
  }
}
