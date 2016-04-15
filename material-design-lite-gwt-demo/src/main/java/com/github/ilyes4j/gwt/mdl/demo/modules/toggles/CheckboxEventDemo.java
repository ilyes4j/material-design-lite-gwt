package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Check box change event demo. */
public class CheckboxEventDemo implements EntryPoint {

  /** Change the label on check box toggle. */
  public final void onModuleLoad() {

    // setup a check box and set its label
    final Checkbox box = new Checkbox("Enabled");
    // make it checked
    box.setValue(true);
    // set a ripple on it
    box.setRipple(Ripple.HAS_RIPPLE);

    // add a change listener
    box.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        // on check toggle change the label
        box.setText(event.getValue() ? "Enabled" : "Disabled");
      }
    });

    // add the check box to the page
    RootPanel.get("checkboxEventContainer").add(box);
  }
}
