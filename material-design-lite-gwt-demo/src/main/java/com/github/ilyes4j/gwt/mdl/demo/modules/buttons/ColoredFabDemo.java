package com.github.ilyes4j.gwt.mdl.demo.modules.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createFab;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.NONE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.google.gwt.core.client.EntryPoint;

/** Colored Fab buttons demo. */
public class ColoredFabDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the icon inside the buttons
    final String ico = "add";

    // colored fab button with an add icon
    get("ctnr_01").add(createFab(COLORED, NONE, ico));

    // colored fab button with an add icon and ripple
    get("ctnr_02").add(createFab(COLORED, HAS_RIPPLE, ico));
  }
}
