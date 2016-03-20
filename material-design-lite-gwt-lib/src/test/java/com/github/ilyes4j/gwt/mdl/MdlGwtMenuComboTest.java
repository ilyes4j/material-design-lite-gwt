package com.github.ilyes4j.gwt.mdl;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;

/**
 * Tests for the {@link MenuCombo} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtMenuComboTest extends MdlGwtBaseTest {

  /**
   * Call all available methods in the {@link MenuCombo} type in order to track
   * interface evolutions. Methods in {@link IMenu} are not checked.
   */
  public final void testBreakingChange() {

    Button btn = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Menu");

    // setup an instance of type MenuCombo
    MenuCombo menu = new MenuCombo(btn);

    // make sure all public methods are stable
    menu.addItem("SomeItem", true);

    assertTrue(true);
  }
}
