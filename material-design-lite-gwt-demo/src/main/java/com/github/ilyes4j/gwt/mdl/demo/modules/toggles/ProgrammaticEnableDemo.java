package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Setting the enabled state. */
public class ProgrammaticEnableDemo implements EntryPoint {

  /** Set the enabled state of the switch when the toggle is clicked. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("programmaticEnableContainer");
    // enable both toggle to sit on the same line
    String width = "auto";
    // the initial state of the switch
    boolean state = true;

    // setup a toggle to control the enabled state
    Checkbox enable = new Checkbox("Enable/Disable");
    enable.setValue(state);
    enable.setRipple(Ripple.HAS_RIPPLE);
    enable.setFace(CheckBoxStyle.CHECKBOX);
    enable.setWidth(width);
    root.add(enable);

    final Checkbox box = new Checkbox("");
    box.addStyleName(Demo.DEMO.css().inline());
    box.setValue(state);
    box.setRipple(Ripple.HAS_RIPPLE);
    box.setFace(CheckBoxStyle.SWITCH);
    box.setWidth(width);
    root.add(box);

    // toggle the enabled state of the switch when the check box is clicked
    enable.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        box.setEnabled(event.getValue());
      }
    });
  }
}
