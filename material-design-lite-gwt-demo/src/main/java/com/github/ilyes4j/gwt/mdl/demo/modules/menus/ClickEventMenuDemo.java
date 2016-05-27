package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createRaised;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.google.gwt.core.client.EntryPoint;

/** Demonstrates the click event of the menu component. */
public class ClickEventMenuDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    // setup the action button.
    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Choose an option");
    ClickEventHelper.buildDemo(new MenuCombo(btn));
  }
}
