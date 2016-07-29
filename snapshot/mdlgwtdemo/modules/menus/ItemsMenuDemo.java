package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.google.gwt.core.client.EntryPoint;

/** Demo for the addition and removal of items for menus after upgrade. */
public class ItemsMenuDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Button action = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "action");
    ItemsHelper.buildDemo(new MenuCombo(action));
  }
}
