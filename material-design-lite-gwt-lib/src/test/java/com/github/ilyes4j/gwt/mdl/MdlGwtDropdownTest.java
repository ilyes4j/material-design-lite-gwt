package com.github.ilyes4j.gwt.mdl;

import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;

/**
 * Tests for the Material {@link Dropdown} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtDropdownTest extends MdlGwtBaseTest {

  /**
   * Call all available methods in {@link Dropdown} in order to track interface
   * evolutions. There is no need to check {@link IMenu} methods as they are
   * checked in a dedicated test case ; {@link MdlGwtIMenuTest};
   */
  public final void testBreakingChange() {

    // setup an instance of type Menu
    Dropdown menu = new Dropdown();

    // make sure all public methods are stable
    menu.addItem("Another Item", false);
    menu.addItem("Some Item");
    menu.addItem("Yet Another Item", "Value");
    menu.getSelectedIndex();
    menu.setSelected(0);
    menu.getSelected();

    assertTrue(true);
  }
}
