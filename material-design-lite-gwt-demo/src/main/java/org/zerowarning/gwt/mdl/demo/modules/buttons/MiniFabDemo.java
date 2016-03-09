package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createMiniFab;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/** Mini Fab buttons demo. */
public class MiniFabDemo implements EntryPoint {

  public void onModuleLoad() {

    final String ICO = "add";

    // create a mini fab
    get("ctnr_22").add(createMiniFab(FAB_NO_COLOR, NONE, ICO));

    // create a colored mini fab
    get("ctnr_23").add(createMiniFab(COLORED, NONE, ICO));
  }
}
