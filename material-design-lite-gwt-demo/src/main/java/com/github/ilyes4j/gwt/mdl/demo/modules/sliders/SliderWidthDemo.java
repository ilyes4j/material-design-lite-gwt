package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for changing the width of the slider. */
public class SliderWidthDemo implements EntryPoint {

  /** Apply a fixed width on the slider. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("widthDemo");
    Slider slider = new Slider();
    slider.setWidth("300px");
    root.add(slider);
  }
}
