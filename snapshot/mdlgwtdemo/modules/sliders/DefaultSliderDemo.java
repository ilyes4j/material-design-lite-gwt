package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for a basic slider component. */
public class DefaultSliderDemo implements EntryPoint {

  /** Setup the most basic slider. */
  public final void onModuleLoad() {
    RootPanel.get("defaultDemo").add(new Slider());
  }
}
