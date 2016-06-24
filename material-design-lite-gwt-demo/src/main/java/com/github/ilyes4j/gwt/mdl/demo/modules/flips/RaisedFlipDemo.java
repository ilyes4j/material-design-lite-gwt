package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the flip raised face. */
public class RaisedFlipDemo implements EntryPoint {

  /** Add a flip with the raised face and the default color configuration. */
  public final void onModuleLoad() {
    final Flip box = new Flip("Flip");
    box.setFace(ButtonType.RAISED);
    box.setRipple(Ripple.HAS_RIPPLE);
    RootPanel.get("raisedContainer").add(box);
  }
}
