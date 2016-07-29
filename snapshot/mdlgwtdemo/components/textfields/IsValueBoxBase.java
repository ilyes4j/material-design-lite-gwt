package com.github.ilyes4j.gwt.mdl.components.textfields;

import java.text.ParseException;

import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

/**
 * Interface containing all the methods exposed by {@link ValueBoxBase} but not
 * endorsed by any interface.
 * 
 * @param <T>
 *          the value type
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface IsValueBoxBase<T> {

  /**
   * If a keyboard event is currently being handled on this text box, calling
   * this method will suppress it. This allows listeners to easily filter
   * keyboard input.
   */
  void cancelKey();

  /**
   * Gets the current position of the cursor (this also serves as the beginning
   * of the text selection).
   * 
   * @return the cursor's position
   */
  int getCursorPos();

  /**
   * Gets the text currently selected within this text box.
   * 
   * @return the selected text, or an empty string if none is selected
   */
  String getSelectedText();

  /**
   * Gets the length of the current text selection.
   * 
   * @return the text selection length
   */
  int getSelectionLength();

  /**
   * Return the parsed value, or null if the field is empty.
   * 
   * @return the value of the textbox
   * 
   * @throws ParseException
   *           if the value cannot be parsed
   */
  T getValueOrThrow() throws ParseException;

  /**
   * Determines whether or not the widget is read-only.
   * 
   * @return <code>true</code> if the widget is currently read-only,
   *         <code>false</code> if the widget is currently editable
   */
  boolean isReadOnly();

  /**
   * Selects all of the text in the box.
   * 
   * This will only work when the widget is attached to the document and not
   * hidden.
   */
  void selectAll();

  /**
   * 
   * @param align
   *          defines how the text should be horizontally anchored
   */
  void setAlignment(TextAlignment align);

  /**
   * Sets the cursor position.
   * 
   * This will only work when the widget is attached to the document and not
   * hidden.
   * 
   * @param pos
   *          the new cursor position
   */
  void setCursorPos(int pos);

  /**
   * Turns read-only mode on or off.
   * 
   * @param readOnly
   *          if <code>true</code>, the widget becomes read-only; if
   *          <code>false</code> the widget becomes editable
   */
  void setReadOnly(boolean readOnly);

  /**
   * Sets the range of text to be selected.
   * 
   * This will only work when the widget is attached to the document and not
   * hidden.
   * 
   * @param pos
   *          the position of the first character to be selected
   * @param length
   *          the number of characters to be selected
   */
  void setSelectionRange(int pos, int length);
}
