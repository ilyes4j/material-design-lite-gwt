package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.TextArea;

/**
 * A {@link MultilineTextField} is a {@link TextfieldBase} wrapped around a
 * {@link TextArea}. It adds specific behaviors related to text areas such as
 * the minimum displayed rows count and the maximum amount of lines that can be
 * input by the user.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MultilineTextField extends TextfieldBase<TextArea> {

  /**
   * Setup an instance of {@link TextfieldBase} wrapped around a
   * {@link TextArea}.
   */
  public MultilineTextField() {
    super(new TextArea());
  }

  /**
   * Define the label to be displayed with the text area when setting up the
   * instance.
   * 
   * @param inputLabel
   *          a text to be displayed when the text area is empty
   */
  public MultilineTextField(final String inputLabel) {
    this();
    setLabel(inputLabel);
  }

  /**
   * @param minRows
   *          the minimum displayed rows count.
   */
  public final void setMinRowsCount(final int minRows) {
    setAttribute(MIN_ROWS_ATTR, minRows);
  }

  /**
   * @param maxLines
   *          the maximum number of lines input into the area.
   */
  public final void setMaxLines(final int maxLines) {
    setAttribute(MAX_ROWS_ATTR, maxLines);
  }

  /**
   * Sets the value of an integer attribute for the {@link TextArea} Widget.
   * 
   * @param attribute
   *          the name of the parameter to be set
   * 
   * @param value
   *          the value of the parameter
   */
  private void setAttribute(final String attribute, final int value) {
    TextArea area = asTextBoxBase();
    String valueStr = String.valueOf(value);
    area.getElement().setAttribute(attribute, valueStr);
  }

  /**
   * DOM attribute name for {@link TextArea} that will be used to set the
   * minimum displayed rows count.
   */
  private static final String MIN_ROWS_ATTR = "rows";

  /**
   * DOM attribute name for {@link TextArea} that will be used to set the
   * maximum displayed rows count.
   */
  private static final String MAX_ROWS_ATTR = "maxrows";
}
