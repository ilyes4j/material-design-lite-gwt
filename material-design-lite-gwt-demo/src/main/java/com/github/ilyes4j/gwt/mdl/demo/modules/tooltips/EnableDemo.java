package com.github.ilyes4j.gwt.mdl.demo.modules.tooltips;

import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipPosition.BOTTOM;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipStyle.DEFAULT;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.components.tooltips.Tooltip;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for enabling and disabling tooltips. */
public class EnableDemo implements EntryPoint {

  /** Make the tooltip disabled when the toggle is pushed. */
  public final void onModuleLoad() {

    String style = Demo.DEMO.css().margin();
    String width = "auto";

    RootPanel root = RootPanel.get("enableContainer");

    final Checkbox enable = new Checkbox("Enable/disable");
    enable.addStyleName(style);
    enable.setWidth(width);
    enable.setValue(false);
    enable.setFace(CheckBoxStyle.CHECKBOX);
    enable.setRipple(Ripple.HAS_RIPPLE);
    root.add(enable);

    final Checkbox print = new Checkbox("print");
    print.addStyleName(style);
    print.setWidth(width);
    print.setValue(false);
    print.setFace(CheckBoxStyle.ICON);
    print.setRipple(Ripple.HAS_RIPPLE);
    root.add(print);

    final Tooltip tip = new Tooltip(print, "Enabled", BOTTOM, DEFAULT);
    tip.setEnabled(false);

    enable.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        tip.setEnabled(event.getValue());
      }
    });
  }
}
