package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Default check box demo. */
public class CheckboxDemo implements EntryPoint {

  /** When the page loads add the check box. */
  public final void onModuleLoad() {

    // create a check box and set the label
    Checkbox box = new Checkbox("Checkbox");
    // make the check box checked
    box.setValue(true);
    // display a ripple on click
    box.setRipple(Ripple.HAS_RIPPLE);
    // attach the check box to the container
    RootPanel.get("checkboxContainer").add(box);
  }
}
