package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import com.github.ilyes4j.gwt.mdl.components.sliders.InputEvent;
import com.github.ilyes4j.gwt.mdl.components.sliders.InputHandler;
import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.github.ilyes4j.gwt.mdl.components.sliders.SliderInput;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for a basic slider component. */
public class InputEventDemo implements EntryPoint {

  /** Setup a simple slider. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("inputDemo");

    Slider slider = new Slider();
    slider.setWidth("300px");
    root.add(slider);

    final Label lbl = new Label();
    lbl.setText(slider.toString());
    root.add(lbl);

    slider.addInputHandler(new InputHandler() {

      @Override
      public void onInput(final InputEvent event) {
        SliderInput source = (SliderInput) event.getSource();
        lbl.setText(source.toString());
      }
    });
  }
}
