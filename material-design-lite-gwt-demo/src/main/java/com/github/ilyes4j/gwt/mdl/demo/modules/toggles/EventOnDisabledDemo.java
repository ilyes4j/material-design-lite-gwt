package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/** Check whether events are sent when toggle is disabled. */
public class EventOnDisabledDemo implements EntryPoint {

  /**
   * Click the toggle twice to make sure the value change event is not
   * dispatched when the toggle is disabled.
   */
  public void onModuleLoad() {

    final RootPanel root = RootPanel.get("eventOnDisabled");

    // builing the demo instructions message
    StringBuilder sb = new StringBuilder();
    sb.append("Click the toggle twice to make sure the value change ");
    sb.append("event is not dispatched when the toggle is disabled.");

    // setting up the instructions element
    final Label lbl = new Label();
    lbl.setText(sb.toString());
    root.add(lbl);

    // setting up the target of the demonstration
    Checkbox box = new Checkbox("Disabled");
    box.setEnabled(false);
    box.setFace(CheckBoxStyle.CHECKBOX);
    box.setRipple(Ripple.HAS_RIPPLE);
    root.add(box);

    box.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        // display a message if the change even is captured
        Label lbl = new Label();
        lbl.setText("Value change Dispatched !");
        root.add(lbl);
      }
    });
  }
}
