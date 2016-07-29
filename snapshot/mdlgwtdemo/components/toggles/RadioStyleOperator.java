package com.github.ilyes4j.gwt.mdl.components.toggles;

/**
 * <p>
 * Material face manager for the material radio button.
 * </p>
 * <p>
 * The material Radio Button provides a single material face, but since the
 * radio button is {@link CheckboxBase}, a face manager with a single option
 * enumeration should be provided.
 * </p>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class RadioStyleOperator extends ToggleStyleOperator<RadioStyle> {

  /**
   * Setup the radio button face manager and provide the appropriate switchers
   * to ensure radio button face initializes properly.
   */
  public RadioStyleOperator() {
    super(new MainRadioSwitcher(), new InputRadioSwitcher(),
        new LabelRadioSwitcher());
  }

  @Override
  protected RadioStyle defaultFlavor() {
    return RadioStyle.RADIO;
  }
}
