package com.github.ilyes4j.gwt.mdl.components.textfields;

import com.google.gwt.user.client.ui.TextBoxBase;

/**
 * Enables a component to claim itself a {@link TextBoxBase}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @param <T>
 */
public interface IsTextBoxBase<T extends TextBoxBase> {

  /**
   * @return the textbox inside the component
   */
  T asTextBoxBase();
}
