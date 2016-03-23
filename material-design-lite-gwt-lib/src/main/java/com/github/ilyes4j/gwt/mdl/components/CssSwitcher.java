package com.github.ilyes4j.gwt.mdl.components;

import java.util.Map;

import com.google.gwt.dom.client.Element;

/**
 * A switcher have two major purposes :
 * 
 * <ol>
 * <li>Remove the boiler plate code from CSS enumerators.
 * <p>
 * The switcher defines the CSS class that corresponds to each enumeration
 * constant which avoid polluting the enumeration with the same boilerplate code
 * for storing and accessing the corresponding CSS class.
 * </p>
 * </li>
 * <li>Manage switching between CSS classes inside components.</li>
 * <p>
 * Inside the component, the switcher manages the switching between the CSS
 * classes. The switcher is responsible for applying the appropriate CSS class
 * and then removing the previously set CSS class when a new class is applied.
 * </p>
 * </ol>
 * 
 * <h3>How to use the switcher</h3>
 * <ol>
 * <li>Define a sub-type that appoint the enumeration to be handled</li>
 * <li>Knowing the enumeration to be managed enables the sub-type to define a
 * static {@link Map} member to hold the mapping between the enumeration
 * constants and the CSS class related to the enumerations.</li>
 * <li>The sub-type defines an implementation of
 * {@link CssSwitcher#getMappings()} that returns the mappings stored in the
 * static member defined earlier. The mappings can be defined in a static block
 * or during the first invocation of the method. But either way, there should
 * always be a single copy of the mappings to optimize memory consumption.</li>
 * </ol>
 * 
 * @param <T>
 *          the Enumeration type to manage by the switcher
 * 
 * @author Mohamed Ilyes DIMASSI
 * 
 */
public abstract class CssSwitcher<T extends Enum<T>> {

  /**
   * The element managed by the CSS switcher.
   * 
   * @param inputTarget
   *          the DOM element managed by the CSS switcher
   */
  public final void setTarget(final Element inputTarget) {
    this.target = inputTarget;
  }

  /**
   * 
   * @return the DOM element managed by the CSS switcher
   */
  public final Element getTarget() {
    return target;
  }

  /**
   * 
   * @param inputValue
   *          the enumeration option to be set
   */
  public final void setValue(final T inputValue) {
    // don't do anything if the requested option is not defined
    if (inputValue == null) {
      return;
    }

    // don't do anything if the requested option is the same that as one
    // already applied
    if (this.value == inputValue) {
      return;
    }

    // remove the previously set option
    // First retrieve the CSS class related to the enumeration option using the
    // stored mappings, then remove the CSS class from the class list for
    // the managed element
    MdlGwtUtils.removeClass(target, toString());

    // save the requested option and make it the current option
    this.value = inputValue;

    // set the CSS class related to the newly acquired option
    MdlGwtUtils.addClass(target, toString());
  }

  /**
   * @return the stored enumeration option
   */
  public final T getValue() {
    return value;
  }

  /**
   * @return the CSS class associated to the current enumeration option
   */
  public final String toString() {
    return mappings.get(value);
  }

  /**
   * The mapping is defined in sub-types to enable the switcher to pick the
   * appropriate CSS class for a given enumeration option.
   * 
   * @return the association between an {@link Enum} constant and the
   *         corresponding CSS class literal
   */
  protected abstract Map<T, String> getMappings();

  /**
   * <p>
   * For each switcher instance there is a {@link Map} member variable to store
   * the mapping between the enumeration options and the corresponding CSS
   * class. It would have been much better if all switcher instances could
   * reference the same mappings stored in a static member. This is just
   * impossible with JAVA. There is nothing that can be done about it since this
   * is a generic class, and therefore static members cannot be applied on the
   * generic parameter.
   * </p>
   * <p>
   * However this does not prevent the sub-types from defining a static variable
   * to store the mappings, considering that they would provide a value for
   * generic parameter of the switcher. The static variable is then returned by
   * the {@link CssSwitcher#getMappings()} method. In this situation, only the
   * reference to the static variable is duplicated in each switcher instance
   * not the entire mapping content.
   * </p>
   */
  private Map<T, String> mappings = getMappings();

  /**
   * Stores the current option for the managed enumeration type.
   */
  private T value;

  /**
   * Stores the DOM element managed by this CSS switcher.
   */
  private Element target;
}
