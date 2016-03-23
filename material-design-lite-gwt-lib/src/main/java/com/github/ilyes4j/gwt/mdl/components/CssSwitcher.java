package com.github.ilyes4j.gwt.mdl.components;

import java.util.Map;

import com.google.gwt.dom.client.Element;

/**
 * A selector have two major purposes :
 * 
 * <ol>
 * <li>Remove the boiler plate code from CSS enumerators.
 * <p>
 * The selector defines the CSS class that corresponds to each enumeration
 * constant which avoid polluting the enumeration with the same boilerplate code
 * for storing and accessing the corresponding CSS class.
 * </p>
 * </li>
 * <li>Manage switching between CSS classes inside components.</li>
 * <p>
 * Inside the component using the css class variations. The selector is
 * responsible for applying the appropriate CSS class and then removing the
 * previously set CSS class when a new class is applied.
 * </p>
 * </ol>
 * 
 * @param <T>
 *          the Enumeration to manage
 * 
 * @author Mohamed Ilyes DIMASSI
 * 
 */
public abstract class CssSwitcher<T extends Enum<T>> {

  /**
   * The component for which the selector should manage CSS class switching.
   * 
   * @param inputTarget
   *          the DOM element to manage
   */
  public final void setTarget(final Element inputTarget) {
    this.target = inputTarget;
  }

  /**
   * 
   * @param inputValue
   *          the css selector constant value to be set
   */
  public final void setValue(final T inputValue) {
    // don't do anything if the requested anchor is not defined
    if (inputValue == null) {
      return;
    }

    // don't do anything if the requested anchoring is the same anchoring
    // already applied
    if (this.value == inputValue) {
      return;
    }

    // remove the previously set anchoring
    MdlGwtUtils.removeClass(target, toString());

    // save the requested anchoring
    this.value = inputValue;

    // use the safe method to set the css selector
    MdlGwtUtils.addClass(target, toString());
  }

  @Override
  public final String toString() {
    return mappings.get(value);
  }

  /**
   * Mapping is defined in sub-types to enable the selector wrapper to pick the
   * right CSS class for a given enum constant.
   * 
   * @return the association between an {@link Enum} constant and the
   *         corresponding CSS class literal
   */
  public abstract Map<T, String> getMappings();

  /**
   * @return the stored css selector enum constant
   */
  protected final T getValue() {
    return value;
  }

  /**
   * The reference on the mapping is instance based. This is not an ideal option
   * regarding memory consumption. In reality only the reference is duplicated
   * across instances. If everything is done right, the The map should be a
   * class variable shared by all instances.
   */
  private Map<T, String> mappings = getMappings();

  /**
   * Stores the current value for the property.
   */
  private T value;

  /**
   * Stores the DOM element to which apply the css selector.
   */
  private Element target;
}
