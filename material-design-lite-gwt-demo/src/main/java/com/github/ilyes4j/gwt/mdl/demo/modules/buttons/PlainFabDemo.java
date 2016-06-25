package com.github.ilyes4j.gwt.mdl.demo.modules.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createFab;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.NONE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.google.gwt.core.client.EntryPoint;

/** Plain Fab buttons demo. */
public class PlainFabDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the icon inside the buttons
    final String ico = "add";

    // Plain fab button with an add icon
    get("ctnr_03").add(createFab(BTN_NO_COLOR, NONE, ico));

    // Plain fab button with an add icon and ripple
    get("ctnr_04").add(createFab(BTN_NO_COLOR, HAS_RIPPLE, ico));

    // Disabled fab button with an add icon
    Button btnFab = createFab(BTN_NO_COLOR, NONE, ico);
    btnFab.setEnabled(false);
    get("ctnr_05").add(btnFab);
  }
}
