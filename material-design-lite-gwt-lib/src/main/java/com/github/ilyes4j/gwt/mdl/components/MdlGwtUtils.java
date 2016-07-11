package com.github.ilyes4j.gwt.mdl.components;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
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
   * The disabled property name.
   */
  public static final String DISABLED = "disabled";

  /**
   * Private constructor for the util class.
   */
  private MdlGwtUtils() {
  }

  /**
   * apply the disabled property for a DOM element if the element should be
   * disabled.
   * 
   * @param elt
   *          the target element
   * 
   * @param enabled
   *          <code>true</code> to remove the disabled property and
   *          <code>false</code> to add it
   * 
   */
  public static void setEnabled(final Element elt, final boolean enabled) {

    // the provided element is undefined => don't do anything
    if (elt == null) {
      return;
    }

    if (enabled) {
      // completely remove the disabled property when false
      elt.removeAttribute(DISABLED);
    } else {
      // add the disabled property to the DOM when true
      elt.setAttribute(DISABLED, "");
    }
  }

  /**
   * Makes sure the element parameter have an id. If the element contains an id,
   * then nothing happens, otherwise, the element is provided with a generated
   * unique id.
   * 
   * @param element
   *          the element for which an id should be insured
   */
  public static void insureId(final Element element) {

    // the provided element is undefined => don't do anything
    if (element == null) {
      return;
    }

    // retrieve the id of the element
    String id = element.getId();

    // if the id attribute is defined => don't do anything
    if (id != null && !id.isEmpty()) {
      return;
    }

    // provide the element with a uniquely generated id
    element.setId(Document.get().createUniqueId());
  }

  /**
   * Helper method that sets the value to the "for" attribute in a DOM element.
   * This attribute helps wiring parts together inside an mdl component and also
   * binds mdl components together. The "for" indicates that the the embedding
   * element is referencing another element in the component. The value of the
   * "for" attribute is the id of the referenced element.
   * 
   * @param element
   *          the target element to be processed
   * 
   * @param value
   *          the value tobe set to the "for" attribute
   */
  public static void setFor(final Element element, final String value) {

    // if the target is undefined, don't do anything
    if (element == null) {
      return;
    }

    // if the value provided is undefined don't do anything
    if (value == null || value.isEmpty()) {
      return;
    }

    // add an attribute named 'for' and set its content
    element.setAttribute(FOR_ATTR, value);
  }

  /**
   * <p>
   * Set the property for a DOM element object, not to be confused with element
   * attributes.
   * </p>
   * <p>
   * To distinguish between properties and attributes lets consider the
   * following input element :<br>
   * &lt;input id=&quot;inrang&quot; type=&quot;range&quot; min=&quot;0&quot;
   * max=&quot;100&quot;&gt;
   * </p>
   * The current value is set through the value <code>PROPERTY</code> =>
   * inrang["value"] = 50; <br>
   * The initial value is set using the value <code>ATTRIBUTE</code> =>
   * inrang.setAttribute("value", 0);
   * 
   * @param elt
   *          the target element
   * 
   * @param prop
   *          the target property
   *
   * @param val
   *          the target value
   */
  public static native void setProperty(final Element elt, final String prop,
      final double val)
      /*-{
        elt[prop] = val;
      }-*/;

  /**
   * Retrieve the property value for an element.
   * 
   * @param elt
   *          the target element of the value set
   * 
   * @param prop
   *          the target property to set
   * 
   * @return the value of the property being set
   */
  public static native double getProperty(final Element elt, final String prop)
  /*-{
    var value = elt[prop];
    
    //numeric encoded into a string
    if(typeof value === "string"){
      value = parseFloat(value);
    }
    
    return value;
  }-*/;

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
   * @param element
   *          the {@link Element} to which the css class will be applied
   * 
   * @param style
   *          any {@link Object} with a {@link Object#toString()} method
   *          returning the css class to be applied.
   * 
   * @see MdlGwtUtils#assertStyle(Object, Object)
   */
  public static void addClass(final Element element, final Object style) {

    if (assertStyle(element, style)) {
      element.addClassName(style.toString());
    }
  }

  /**
   * Same behavior as {@link MdlGwtUtils#removeStyle(UIObject, Object)} applied
   * to {@link Element}.
   * 
   * @param element
   *          the {@link Element} to which the css selector will be applied
   * 
   * @param style
   *          any {@link Object} with a {@link Object#toString()} method
   *          returning the css selector to be applied.
   */
  public static void removeClass(final Element element, final Object style) {
    if (assertStyle(element, style)) {
      element.removeClassName(style.toString());
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
  private static boolean assertStyle(final Object object, final Object style) {

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

  /**
   * Keeps the name of the 'for' attribute.
   */
  private static final String FOR_ATTR = "for";
}
