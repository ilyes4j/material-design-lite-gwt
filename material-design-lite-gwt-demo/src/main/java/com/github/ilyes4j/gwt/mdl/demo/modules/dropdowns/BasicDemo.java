package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;

/** Setup a basic dropdown menu. */
public class BasicDemo implements EntryPoint {

  /** When the page loads add the dropdown menu. */
  public final void onModuleLoad() {

    // instanciate a dropdown
    Dropdown dropdown = new Dropdown();

    // add the items to the dropdown
    dropdown.addItem("Some action");
    dropdown.addItem("Another action");
    dropdown.addItem("Yet another action");

    // attach the dropdown to its parent
    get("default-dropdown").add(dropdown);
  }
}
