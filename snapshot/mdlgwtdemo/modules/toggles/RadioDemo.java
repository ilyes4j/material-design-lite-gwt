package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.RadioButton;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Radio Button Demo. */
public class RadioDemo implements EntryPoint {

  /** Add 3 radio buttons. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("radioContainer");

    root.add(getRadio("radio1"));
    root.add(getRadio("radio2"));
    root.add(getRadio("radio3"));
  }

  /**
   * @param value
   *          the value and text to be set for the radio
   * 
   * @return a radio button with a text a value and a ripple
   */
  public static RadioButton getRadio(final String value) {
    String group = "group";
    RadioButton radio = new RadioButton(group);
    radio.setRipple(Ripple.HAS_RIPPLE);
    radio.setText(value);
    radio.addStyleName(Demo.DEMO.css().margin());
    return radio;
  }
}
