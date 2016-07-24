package com.github.ilyes4j.gwt.mdl.demo.modules.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createIcon;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.NONE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.google.gwt.core.client.EntryPoint;

/** Icon buttons demo. */
public class IconButtonDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the icon inside the buttons
    final String ico = "mood";

    // create an icon button
    get("ctnr_18").add(createIcon(BTN_NO_COLOR, NONE, ico));

    // create a colored icon button
    get("ctnr_19").add(createIcon(PRIMARY, NONE, ico));

    // create an accent colored icon button
    get("ctnr_20").add(createIcon(ACCENT, NONE, ico));

    // create an accent colored icon button with ripple
    get("ctnr_21").add(createIcon(ACCENT, HAS_RIPPLE, ico));
  }
}
