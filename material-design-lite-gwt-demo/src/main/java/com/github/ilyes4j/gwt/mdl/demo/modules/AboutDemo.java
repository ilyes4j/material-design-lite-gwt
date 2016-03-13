package com.github.ilyes4j.gwt.mdl.demo.modules;

import com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils;
import com.google.gwt.core.client.EntryPoint;

/**
 * {@link EntryPoint} containing the GWT part of the about page.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class AboutDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  @Override
  public final void onModuleLoad() {

    // put the main navigation bar in the header for the demo page.
    MdlGwtDemoUtils.insertMainbar();
  }
}
