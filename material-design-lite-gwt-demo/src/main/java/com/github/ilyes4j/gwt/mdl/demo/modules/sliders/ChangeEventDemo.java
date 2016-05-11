package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.github.ilyes4j.gwt.mdl.components.sliders.SliderInput;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for the slider change event. */
public class ChangeEventDemo implements EntryPoint {

  /** Perform an action when the value of the slider changes. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("changeDemo");

    Slider slider = new Slider();
    slider.setWidth("300px");
    root.add(slider);

    final Label lbl = new Label();
    lbl.setText(slider.toString());
    root.add(lbl);

    slider.addChangeHandler(new ChangeHandler() {

      @Override
      public void onChange(final ChangeEvent event) {
        SliderInput source = (SliderInput) event.getSource();
        lbl.setText(source.toString());
      }
    });
  }
}
