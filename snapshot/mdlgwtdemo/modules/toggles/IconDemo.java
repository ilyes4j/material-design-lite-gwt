package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Icon demo. */
public class IconDemo implements EntryPoint {

  /** Add an icon demo with a ripple. */
  public final void onModuleLoad() {

    final Checkbox box = new Checkbox("add");
    box.setRipple(Ripple.HAS_RIPPLE);
    box.setFace(CheckBoxStyle.ICON);
    RootPanel.get("iconContainer").add(box);
  }
}
