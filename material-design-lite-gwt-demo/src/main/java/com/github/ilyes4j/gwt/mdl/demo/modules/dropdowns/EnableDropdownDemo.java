package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import com.github.ilyes4j.gwt.mdl.demo.modules.menus.EnableHelper;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;

/** Demonstrates enabling/disabling dropdowns. */
public final class EnableDropdownDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    EnableHelper.buildDemo(new Dropdown());
  }
}
