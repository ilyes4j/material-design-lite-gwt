package com.github.ilyes4j.gwt.mdl.demo.modules.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createRaised;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.NONE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.google.gwt.core.client.EntryPoint;

/** Raised buttons demo. */
public class RaisedButtonDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    final String txt = "Button";

    // create a plain raised button
    get("ctnr_06").add(createRaised(BTN_NO_COLOR, NONE, txt));

    // create a plain raised button with ripple
    get("ctnr_07").add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, txt));

    // create a plain raised disabled button
    Button btnRaised = createRaised(BTN_NO_COLOR, NONE, txt);
    btnRaised.setEnabled(false);
    get("ctnr_08").add(btnRaised);
  }
}
