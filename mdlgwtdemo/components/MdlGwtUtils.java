package com.github.ilyes4j.gwt.mdl.components;

import com.google.gwt.user.client.ui.UIObject;

/**
 * Contains general purpose and recurring code snippet used through out the
 * project. This class centralizes all these procedures to avoid code
 * duplication and redundancy.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public final class MdlGwtUtils {

  /**
   * Private constructor for the util class.
   */
  private MdlGwtUtils() {
  }

  /**
   * Make sure the index provided as input is inside the range of possible
   * elements of a list.
   * 
   * @param size
   *          the size of the list
   * 
   * @param index
   *          the index to be checked
   */
  public static void assertIndex(final int size, final int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * When {@link UIObject#addStyleName(String)} is invoked with an empty style
   * name, it raises an exception. In mdl, the absence of a selector is
   * interpreted as the default option for the behavior. For this reason, we
   * need an alternative to {@link UIObject#addStyleName(String)} that does not
   * raise an exception when it encounter an empty css selector.
   * 
   * @param object
   *          the widget to which the css selector will be applied
   * 
   * @param style
   *          any {@link Object} with a {@link Object#toString()} method
   *          returning the css selector to be applied.
   */
  public static void addStyle(final UIObject object, final Object style) {

    if (assertStyle(object, style)) {
      object.addStyleName(style.toString());
    }
  }

  /**
   * Same behavior as {@link MdlGwtUtils#addStyle(UIObject, Object)} but for
   * {@link UIObject#removeStyleName(String)}.
   * 
   * @param object
   *          the widget to which the css selector will be applied
   * 
   * @param style
   *          any {@link Object} with a {@link Object#toString()} method
   *          returning the css selector to be applied.
   * 
   * @see MdlGwtUtils#addStyle(UIObject, Object)
   */
  public static void removeStyle(final UIObject object, final Object style) {
    if (assertStyle(object, style)) {
      object.removeStyleName(style.toString());
    }
  }

  /**
   * 
   * Checks whether the css selector can be applied to the element safely.
   * 
   * @param object
   *          the widget to which the css selector will be applied
   * 
   * @param style
   *          any {@link Object} with a {@link Object#toString()} method
   *          returning the css selector to be applied.
   * 
   * @return true if the all the required conditions are satisfied.
   */
  private static boolean assertStyle(final UIObject object,
      final Object style) {

    // don't do anything if the target element is not defined
    if (object == null) {
      return false;
    }

    // don't do anything if the class selector is not defined or empty
    if (style == null) {
      return false;
    }

    String value = style.toString();

    // don't do anything if the class selector is empty
    if (value.isEmpty()) {
      return false;
    }

    // otherwise all conditions are verified
    return true;
  }
}
