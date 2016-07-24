package com.github.ilyes4j.gwt.mdl.components.ripples;

/**
 * Indicates whether ripples are enabled for the Material component or not.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public enum Ripple {

  /**
   * No ripple for the target component.
   */
  NONE(""),

  /**
   * Apply a ripple for the target component.
   */
  HAS_RIPPLE("mdl-js-ripple-effect");

  /**
   * Create a {@link Ripple} enum and provide its css style name.
   * 
   * @param inputCss
   *          the css style name of the ripple effect.
   */
  Ripple(final String inputCss) {
    this.css = inputCss;
  }

  /**
   * Returns the css selector responsible for the anchoring behavior.
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
