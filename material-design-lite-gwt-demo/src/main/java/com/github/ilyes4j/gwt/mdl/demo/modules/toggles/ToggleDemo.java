package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import java.util.ArrayList;
import java.util.Collection;

import com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils;
import com.google.gwt.core.client.EntryPoint;

/**
 * {@link EntryPoint} containing the GWT part of the toggles demos.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ToggleDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public final void onModuleLoad() {

    Collection<EntryPoint> demos = new ArrayList<>();
    demos.add(new CheckboxDemo());
    demos.add(new RadioDemo());
    demos.add(new SwitchDemo());
    demos.add(new IconDemo());
    demos.add(new CheckboxEventDemo());
    demos.add(new RadioEventDemo());
    demos.add(new ProgrammaticEnableDemo());
    demos.add(new ProgrammaticCheckDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertComponentsNavbar();
  }

}
