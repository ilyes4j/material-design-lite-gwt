package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the flip flat face. */
public class FlatFlipDemo implements EntryPoint {

  /** Add a flip with the default face. */
  public final void onModuleLoad() {
    final Flip box = new Flip("Flip");
    box.setRipple(Ripple.HAS_RIPPLE);
    RootPanel.get("flatContainer").add(box);
  }
}
