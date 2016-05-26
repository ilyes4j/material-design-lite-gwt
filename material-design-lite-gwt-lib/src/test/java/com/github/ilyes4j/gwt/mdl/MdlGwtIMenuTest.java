package com.github.ilyes4j.gwt.mdl;

import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.menus.ItemClickEvent;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor;

/**
 * Tests for the {@link IMenu} interface.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtIMenuTest extends MdlGwtBaseTest {

  /**
   * Call all available methods in the {@link IMenu} interface in order to track
   * interface evolutions.
   */
  public final void testBreakingChange() {

    // setup an instance of type Menu
    IMenu menu = new Menu();

    // make sure all public methods are stable
    menu.addItem("More Items", "More Items", false);
    menu.addItemClickListener(new Menu.ItemClickListener() {

      @Override
      public void onItemClicked(final ItemClickEvent event) {
        // also call ItemClickEvent methods
        event.getIndex();
        event.getValue();
      }
    });
    menu.getItemCount();
    menu.getItemText(0);
    menu.getValue(0);
    menu.isEnabled(0);
    menu.setEnabled(0, false);
    menu.clearMenu();
    menu.setAnchor(MenuAnchor.BOTTOM_LEFT);
    menu.setAnchor(MenuAnchor.BOTTOM_RIGHT);
    menu.setAnchor(MenuAnchor.TOP_RIGHT);
    menu.setAnchor(MenuAnchor.TOP_LEFT);

    assertTrue(true);
  }
}
