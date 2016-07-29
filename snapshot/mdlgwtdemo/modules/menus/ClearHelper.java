package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo Template for clearing menus. */
public final class ClearHelper {

  /** Private default constructor for the utility class. */
  private ClearHelper() {
  }

  /**
   * setup the template.
   * 
   * @param drop
   *          the dropdown to be demonstrated
   */
  public static void buildDemo(final IMenu drop) {

    RootPanel root = RootPanel.get("clearContainer");

    final Checkbox clear = new Checkbox("");
    clear.setValue(true);
    clear.setWidth("auto");
    clear.setRipple(Ripple.HAS_RIPPLE);
    clear.setFace(CheckBoxStyle.SWITCH);
    root.add(clear);

    drop.asWidget().addStyleName(Demo.DEMO.css().inline());
    loadItems(drop);
    root.add(drop);

    clear.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        if (clear.getValue()) {
          loadItems(drop);
        } else {
          drop.clearMenu();
        }
      }
    });
  }

  /**
   * @param iMenu
   *          the menu to be loaded with items.
   */
  private static void loadItems(final IMenu iMenu) {

    final int count = 4;
    String item;

    for (int i = 0; i < count; i++) {
      item = "Item Action " + i;
      iMenu.addItem(item, item, true);
    }
  }
}
