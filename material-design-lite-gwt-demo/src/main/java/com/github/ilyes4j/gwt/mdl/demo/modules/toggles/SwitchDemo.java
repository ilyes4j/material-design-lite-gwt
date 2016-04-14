package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Switch demo. */
public class SwitchDemo implements EntryPoint {

  /** Setup a toggle with a switch face and a ripple. */
  public final void onModuleLoad() {

    final Checkbox box = new Checkbox("Switch");
    box.setRipple(Ripple.HAS_RIPPLE);
    box.setFace(CheckBoxStyle.SWITCH);
    RootPanel.get("switchContainer").add(box);
  }
}
