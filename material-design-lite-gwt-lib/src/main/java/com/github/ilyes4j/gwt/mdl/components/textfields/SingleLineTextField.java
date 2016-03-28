package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Single line text field component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @param <T>
 *          a sub-type of {@link TextBox} to be used
 */
public class SingleLineTextField<T extends TextBox> extends TextfieldBase<T> {

  /**
   * Setup a single line input field.
   * 
   * @param inputBox
   *          the input Widget to wrap
   */
  public SingleLineTextField(final T inputBox) {
    super(inputBox);

    // setting up an error label for the component
    errorLbl = new InlineLabel();
    // setting up the mdl error CSS class
    errorLbl.setStyleName(MDL_TXTFLD_ERR);
    // attaching the error label to the container
    add(errorLbl);
  }

  /**
   * Setup a single line input field and a label.
   * 
   * @param inputLabel
   *          the label to be displayed inside the box
   * 
   * @param inputBox
   *          the input Widget to wrap
   */
  public SingleLineTextField(final String inputLabel, final T inputBox) {
    super(inputLabel, inputBox);
  }

  /**
   * 
   * @param inputValidator
   *          the validation setup to be applied on the input text
   */
  public final void setValidator(final TextValidator inputValidator) {
    // Retrieve the error message
    String error = inputValidator.getErrorMessage();
    // assign thr error message to the error label
    errorLbl.setText(error);

    // Retrieve the validation regular expression
    String pattern = inputValidator.getPattern();
    // assign the regexp to the pattern
    getErrorLabel().getElement().setAttribute(PATTERN, pattern);
  }

  /**
   * Stop validating the text field.
   */
  public final void removeValidator() {
    errorLbl.setText("");
    getErrorLabel().getElement().removeAttribute(PATTERN);
  }

  /**
   * The {@link TextfieldBase} contains an {@link InlineLabel} under the hood to
   * display the hint inside the text box when it is empty.
   * 
   * @return the error container
   */
  protected final InlineLabel getErrorLabel() {
    return errorLbl;
  }

  /**
   * An {@link InlineLabel} showing an error message when the input text is
   * invalid.
   */
  private InlineLabel errorLbl;

  /**
   * The attribute name for validating the input element.
   */
  private static final String PATTERN = "pattern";

  /**
   * CSS class for the error label.
   */
  private static final String MDL_TXTFLD_ERR = "mdl-textfield__error";
}
