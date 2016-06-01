package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import com.github.ilyes4j.gwt.mdl.demo.modules.menus.ClearHelper;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;

/** Demonstrates clearing dropdowns. */
public class ClearDropdownDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    ClearHelper.buildDemo(new Dropdown());
  }
}
