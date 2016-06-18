package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import java.util.ArrayList;
import java.util.Collection;

import com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils;
import com.google.gwt.core.client.EntryPoint;

/**
 * {@link EntryPoint} containing the GWT part of the flip demos.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class FlipDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public final void onModuleLoad() {

    Collection<EntryPoint> demos = new ArrayList<>();
    demos.add(new FlatFlipDemo());
    demos.add(new RaisedFlipDemo());
    demos.add(new FabFlipDemo());
    demos.add(new MinifabFlipDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertExtensionsNavbar();
  }
}
