package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import com.github.ilyes4j.gwt.mdl.demo.modules.menus.ItemsHelper;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;

/** Demo for the addition and removal of items for dropdowns after upgrade. */
public class ItemsDropdownDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    ItemsHelper.buildDemo(new Dropdown());
  }
}
