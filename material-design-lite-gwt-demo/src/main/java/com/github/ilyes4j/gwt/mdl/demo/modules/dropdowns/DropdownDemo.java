package org.zerowarning.gwt.mdl.demo.modules.dropdowns;

import java.util.ArrayList;
import java.util.Collection;

import org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils;

import com.google.gwt.core.client.EntryPoint;

/** code samples for the dropdown demo page. */
public class DropdownDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public final void onModuleLoad() {

    Collection<EntryPoint> demos = new ArrayList<>();
    demos.add(new BasicDemo());
    demos.add(new SelectItemDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertExtensionsNavbar();
  }
};
