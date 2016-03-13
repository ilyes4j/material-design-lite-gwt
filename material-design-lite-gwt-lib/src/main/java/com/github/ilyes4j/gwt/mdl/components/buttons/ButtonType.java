package com.github.ilyes4j.gwt.mdl.components.buttons;

/**
 * {@link ButtonType} controls the shape taken by a material button.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum ButtonType {

  /**
   * Setup a rectangular and button with an elevation effect.
   */
  RAISED("mdl-button--raised"),

  /**
   * Setup a flat and rectangular buttont.
   */
  FLAT(""),

  /**
   * Setup a very small round and flat button that contains an icon.
   */
  ICON("mdl-button--icon"),

  /**
   * Setup a big round elevated button that contains an icon.
   */
  FAB("mdl-button--fab"),

  /**
   * Setup a medium round elevated button that contains an icon.
   */
  MINIFAB("mdl-button--fab mdl-button--mini-fab");

  /**
   * Setup the option and its corresponding css class name.
   * 
   * @param inputCss
   *          the css class name associated with this option
   */
  ButtonType(final String inputCss) {
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
