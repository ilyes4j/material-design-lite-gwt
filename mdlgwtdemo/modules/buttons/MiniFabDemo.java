package com.github.ilyes4j.gwt.mdl.demo.modules.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createMiniFab;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.NONE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.google.gwt.core.client.EntryPoint;

/** Mini Fab buttons demo. */
public class MiniFabDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the icon inside the buttons
    final String ico = "add";

    // create a mini fab
    get("ctnr_22").add(createMiniFab(FAB_NO_COLOR, NONE, ico));

    // create a colored mini fab
    get("ctnr_23").add(createMiniFab(COLORED, NONE, ico));
  }
}
