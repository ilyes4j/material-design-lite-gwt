package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demonstrates the addition and removal of items for IMenus after upgrade. */
public final class ItemsHelper {

  /** Utility class private constructor. */
  private ItemsHelper() {
  }

  /**
   * @param menu
   *          the menu to be demonstrated
   */
  public static void buildDemo(final IMenu menu) {

    RootPanel root = RootPanel.get("addRemoveItemContainer");

    // setup the switcher that determines if the addition and removal happen
    // at the beginning or the end of the menu
    final Checkbox insert = new Checkbox("");
    insert.setWidth("auto");
    insert.setRipple(Ripple.HAS_RIPPLE);
    insert.setFace(CheckBoxStyle.SWITCH);
    root.add(insert);

    // setup the button that adds items to the menu
    Button addItem = Button.createMiniFab(BTN_NO_COLOR, HAS_RIPPLE, "add");
    addItem.addStyleName(Demo.DEMO.css().inline());
    root.add(addItem);

    // setup the button that removes items from the menu
    Button delItem = Button.createMiniFab(BTN_NO_COLOR, HAS_RIPPLE, "remove");
    delItem.addStyleName(Demo.DEMO.css().inline());
    root.add(delItem);

    // style and add the menu to the page
    menu.asWidget().addStyleName(Demo.DEMO.css().inline());
    root.add(menu);

    // add an item at the beginning or at the end of the menu depending on state
    // of the insert toggle
    addItem.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        // the insertion index is based on the state of the insert toggle
        int idx = insert.getValue() ? 0 : menu.getItemCount();
        String val = "Dynamic Action " + menu.getItemCount();
        menu.addItem(val, val, idx, true);
      }
    });

    // delete an item at the beginning or at the end of the menu depending on
    // state of the insert toggle
    delItem.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        // the remove index is based on the state of the insert toggle
        menu.removeItem(insert.getValue() ? 0 : menu.getItemCount() - 1);
      }
    });
  }
}
