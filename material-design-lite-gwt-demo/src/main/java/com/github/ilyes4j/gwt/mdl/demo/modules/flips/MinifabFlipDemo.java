package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.github.ilyes4j.gwt.mdl.extensions.flips.FlipStyle;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the flip mini fab face. */
public class MinifabFlipDemo implements EntryPoint {

  /** Add a flip with the raised face and the default color configuration. */
  public final void onModuleLoad() {

    final Flip box = new Flip("add");
    box.setFace(FlipStyle.MINIFAB);
    box.setRipple(Ripple.HAS_RIPPLE);
    RootPanel.get("minifabContainer").add(box);
  }
}
