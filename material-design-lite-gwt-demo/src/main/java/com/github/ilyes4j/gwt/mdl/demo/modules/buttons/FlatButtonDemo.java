package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFlat;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.buttons.Button;

import com.google.gwt.core.client.EntryPoint;

/** Flat buttons demo. */
public class FlatButtonDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the text inside the buttons
    final String txt = "Button";

    // create a flat button
    get("ctnr_12").add(createFlat(BTN_NO_COLOR, NONE, txt));

    // create a flat button with a ripple
    get("ctnr_13").add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, txt));

    // create disabled flat button
    Button btnFlat = createFlat(BTN_NO_COLOR, NONE, txt);
    btnFlat.setEnabled(false);
    get("ctnr_14").add(btnFlat);
  }
}
