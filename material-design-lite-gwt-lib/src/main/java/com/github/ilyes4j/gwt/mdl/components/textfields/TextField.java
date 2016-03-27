package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.TextBox;

/**
 * A {@link TextfieldBase} wrapped around a {@link TextBox}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class TextField extends TextfieldBase<TextBox> {

  /**
   * Setting up an instance of {@link TextfieldBase} wrapped around a
   * {@link TextBox}.
   */
  public TextField() {
    super(new TextBox());
  }

  /**
   * Setting up an instance of {@link TextfieldBase} wrapped around a
   * {@link TextBox} and a provide the label content.
   * 
   * @param label
   *          same as {@link TextfieldBase#setLabel(String)}
   */
  public TextField(final String label) {
    super(label, new TextBox());
  }
}
