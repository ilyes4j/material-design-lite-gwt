package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Same pattern as {@link TextField}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class PasswordField extends SingleLineTextField<PasswordTextBox> {

  /**
   * Same as {@link TextField#TextField()} but using a {@link PasswordTextBox}
   * instead of {@link TextBox}.
   */
  public PasswordField() {
    super(new PasswordTextBox());
  }

  /**
   * Same as {@link TextField#TextField(String)} but using a
   * {@link PasswordTextBox} instead of {@link TextBox}.
   * 
   * @param label
   *          same as {@link TextfieldBase#setLabel(String)}
   */
  public PasswordField(final String label) {
    super(label, new PasswordTextBox());
  }
}
