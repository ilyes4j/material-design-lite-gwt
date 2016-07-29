package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Setting the checked state. */
public class ProgrammaticCheckDemo implements EntryPoint {

  /** Set the checked state of the switch when the toggle is clicked. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("programmaticCheckContainer");

    // setup the button controlling the switch of the checked state for a toggle
    String text = "Toggle checked";
    Button enable = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, text);
    enable.setRipple(Ripple.HAS_RIPPLE);
    root.add(enable);

    // setup the target toggle to be controlled
    final Checkbox box = new Checkbox("");
    box.addStyleName(Demo.DEMO.css().inline());
    box.setValue(true);
    box.setRipple(Ripple.HAS_RIPPLE);
    box.setFace(CheckBoxStyle.SWITCH);
    box.setWidth("auto");
    root.add(box);

    // flip the checked state when the button is clicked
    enable.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        box.setValue(!box.getValue());
      }
    });
  }
}
