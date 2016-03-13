package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFlat;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/** Flat colored buttons demo. */
public class FlatColoredDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the text inside the buttons
    final String txt = "Button";

    // create a primary colored flat button
    get("ctnr_15").add(createFlat(PRIMARY, NONE, txt));

    // create an accent colored flat button
    get("ctnr_16").add(createFlat(ACCENT, NONE, txt));

    // create an accent colored flat button with a ripple
    get("ctnr_17").add(createFlat(ACCENT, HAS_RIPPLE, txt));
  }
}
