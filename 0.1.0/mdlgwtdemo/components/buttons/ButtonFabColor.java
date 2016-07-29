package com.github.ilyes4j.gwt.mdl.components.buttons;

/**
 * Controls the coloring option of the background of a fab or a mini fab
 * {@link Button}s.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum ButtonFabColor {

  /**
   * Setup a button with no extra coloring.
   */
  FAB_NO_COLOR(""),

  /**
   * Apply the accented theme color to the button.
   */
  COLORED("mdl-button--colored");

  /**
   * Setup the option and its corresponding css class name.
   * 
   * @param inputCss
   *          the css class name associated with this option
   */
  ButtonFabColor(final String inputCss) {
    this.css = inputCss;
  }

  /**
   * Returns the css class name related to this option.
   */
  @Override
  public String toString() {
    return css;
  }

  /**
   * Stores the css class name.
   */
  private final String css;
}
