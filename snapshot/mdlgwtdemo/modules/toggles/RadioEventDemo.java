package com.github.ilyes4j.gwt.mdl.demo.modules.toggles;

import com.github.ilyes4j.gwt.mdl.components.toggles.RadioButton;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Radio change event demo. */
public class RadioEventDemo implements EntryPoint, ValueChangeHandler<Boolean> {

  /** Change the label on radio click. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("radioEventContainer");

    root.add(getWiredRadio("radio1"));
    root.add(getWiredRadio("radio2"));
  }

  @Override
  public void onValueChange(final ValueChangeEvent<Boolean> event) {
    // retrieve the radio button from the event
    RadioButton src = (RadioButton) event.getSource();
    // change the label of the radio to visually reflect the event propagation
    src.setText("change_" + counter++);
  }

  /**
   * @param value
   *          the value and text to be set for the radio
   * 
   * @return a radio button with a text, a value, a ripple and a change
   *         listener.
   * 
   * @see RadioDemo#getRadio(String)
   */
  private RadioButton getWiredRadio(final String value) {
    RadioButton radio = RadioDemo.getRadio(value);
    radio.addValueChangeHandler(this);
    return radio;
  }

  /**
   * Track the count of events fired and use it to change the label of the
   * radios.
   */
  private static int counter = 0;
}
