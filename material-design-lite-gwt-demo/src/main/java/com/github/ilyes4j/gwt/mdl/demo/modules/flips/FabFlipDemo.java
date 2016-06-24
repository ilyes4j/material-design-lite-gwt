package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the flip fab face. */
public class FabFlipDemo implements EntryPoint {

  /** Add a flip with the fab face. */
  public final void onModuleLoad() {

    final Flip box = new Flip("add");
    box.setFace(ButtonType.FAB);
    box.setRipple(Ripple.HAS_RIPPLE);
    RootPanel.get("fabContainer").add(box);
  }
}
