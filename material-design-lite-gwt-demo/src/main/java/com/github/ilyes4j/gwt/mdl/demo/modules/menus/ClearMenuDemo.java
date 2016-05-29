package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.google.gwt.core.client.EntryPoint;

/** Demonstrates clearing menus. */
public class ClearMenuDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Button action = Button.createIcon(BTN_NO_COLOR, HAS_RIPPLE, "more_vert");
    ClearHelper.buildDemo(new MenuCombo(action));
  }
}
