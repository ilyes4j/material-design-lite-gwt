package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.TextBox;

/**
 * Contains methods in {@link TextBox} type but not endorsed under any of the
 * interfaces implemented by {@link TextBox}.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public interface ITextBox {

  /**
   * Gets the maximum allowable length of the text box.
   *
   * @return the maximum length, in characters
   */
  int getMaxLength();

  /**
   * Gets the number of visible characters in the text box.
   *
   * @return the number of visible characters
   */
  int getVisibleLength();

  /**
   * Sets the maximum allowable length of the text box.
   *
   * @param length
   *          the maximum length, in characters
   */
  void setMaxLength(int length);

  /**
   * Sets the number of visible characters in the text box.
   *
   * @param length
   *          the number of visible characters
   */
  void setVisibleLength(int length);
}
