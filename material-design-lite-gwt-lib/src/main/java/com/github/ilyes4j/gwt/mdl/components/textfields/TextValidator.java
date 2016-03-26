package com.github.ilyes4j.gwt.mdl.components.textfields;

/**
 * A text validator is applied on a {@link TextfieldBase} to check whether the
 * input content is as expected. The validator contains a pattern. The pattern
 * is applied to the input using the pattern attribute of the input DOM element.
 * When the input content changes, it is validated against the pattern. If the
 * input text is found to be invalid, then an error message is displayed below
 * the input.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class TextValidator {

  /**
   * @return the pattern used to validate the {@link TextfieldBase}.
   */
  public final String getPattern() {
    return pattern;
  }

  /**
   * @param inputPattern
   *          a regular expression against which the input text is validated
   */
  public final void setPattern(final String inputPattern) {
    this.pattern = inputPattern;
  }

  /**
   * 
   * @return the message to be displayed when the input text does not match the
   *         pattern
   */
  public final String getErrorMessage() {
    return errorMessage;
  }

  /**
   * 
   * @param inputErrorMessage
   *          the error message to be displayed when the input text does not
   *          match the required pattern
   */
  public final void setErrorMessage(final String inputErrorMessage) {
    this.errorMessage = inputErrorMessage;
  }

  /**
   * The regular expression against which the input text is checked.
   */
  private String pattern;

  /**
   * The error message to be displayed if the input text does not match the
   * pattern.
   */
  private String errorMessage;
}
