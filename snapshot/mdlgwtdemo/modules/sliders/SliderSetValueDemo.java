package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for setting the slider value programmatically. */
public class SliderSetValueDemo implements EntryPoint {

  /** When the button is pushed set the value of the slider. */
  public final void onModuleLoad() {

    final int value = 20;
    final String valStr = String.valueOf(20);

    RootPanel root = RootPanel.get("setValueDemo");

    Button btn = Button.createRaised(PRIMARY, HAS_RIPPLE, valStr);
    root.add(btn);

    final Slider slider = new Slider();
    slider.addStyleName(Demo.DEMO.css().inline());
    slider.setWidth("200px");
    root.add(slider);

    btn.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(final ClickEvent event) {
        slider.setValue(value);
      }
    });
  }
}
