package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import com.github.ilyes4j.gwt.mdl.demo.modules.menus.ClickEventHelper;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;

/** Demonstrates the click event of the dropdown component. */
public class ClickEventDropdownDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    ClickEventHelper.buildDemo(new Dropdown());
  }
}
