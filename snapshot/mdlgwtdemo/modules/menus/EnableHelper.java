package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import com.github.ilyes4j.gwt.mdl.components.menus.IMenuCombo;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demonstrates enabling/disabling menus. */
public final class EnableHelper {

  /** Utility class private constructor. */
  private EnableHelper() {
  }

  /**
   * When the toggle is pushed disable/enable the menu.
   * 
   * @param combo
   *          the target of demo
   */
  public static void buildDemo(final IMenuCombo combo) {

    RootPanel root = RootPanel.get("enableContainer");
    final int count = 4;

    final Checkbox enable = new Checkbox("");
    enable.setValue(true);
    enable.setWidth("auto");
    enable.setRipple(Ripple.HAS_RIPPLE);
    enable.setFace(CheckBoxStyle.SWITCH);
    root.add(enable);

    for (int i = 0; i < count; i++) {
      combo.addItem("Item Action " + i, true);
    }
    combo.asWidget().addStyleName(Demo.DEMO.css().inline());
    root.add(combo);

    enable.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        combo.setEnabled(enable.getValue());
      }
    });
  }
}
