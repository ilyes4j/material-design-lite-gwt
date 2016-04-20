package com.github.ilyes4j.gwt.mdl.components.toggles;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;
import com.github.ilyes4j.gwt.mdl.components.ripples.HasRipple;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.ripples.RippleSwitcher;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * This class encapsulates the material side of toggle-based components. It only
 * handles the material design styling of the toggle. Unfortunately, the
 * standard GWT {@link CheckBox} internal structure is not flexible enough to
 * accept the material styling. To build a fully functional material toggle, a
 * {@link Widget} component must be implemented that provides the same features
 * found in {@link CheckBox} while being structurally ready to support the
 * material design. This widget would be responsible for building the DOM
 * structure and wiring the events while {@link ToggleStyleOperator} adds the
 * material look and feel by applying the appropriate CSS classes and behaviors
 * to that component.
 * </p>
 * <p>
 * To easily switch between faces. {@link ToggleStyleOperator} is a generic
 * class using an enumeration as a parameter. The parameter represents the face
 * options that the toggle can choose from.
 * </p>
 * <p>
 * Under the hood, a set of {@link CssSwitcher}s manages the switching between
 * faces. Each {@link CssSwitcher} is responsible for the state of an element in
 * the toggle. When the user sets a face for the toggle, the call is delegated
 * to {@link ToggleStyleOperator#setFace(Enum)} which in itself calls the
 * {@link CssSwitcher#setValue(Enum)} for each part of the toggle.
 * </p>
 * 
 * @param <T>
 *          the face options to choose from
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public abstract class ToggleStyleOperator<T extends Enum<T>>
    implements HasRipple, IToggleFace<T> {

  /**
   * 
   * Make an instance of the style operator by providing the {@link CssSwitcher}
   * set to be used to manage the CSS of the component.
   * 
   * 
   * @param switchCtnr
   *          the container CSS manager
   * 
   * @param switchInput
   *          the input CSS manager
   * 
   * @param switchlabel
   *          the label CSS manager
   */
  public ToggleStyleOperator(final CssSwitcher<T> switchCtnr,
      final CssSwitcher<T> switchInput, final CssSwitcher<T> switchlabel) {
    mainSwitcher = switchCtnr;
    inputSwitcher = switchInput;
    labelSwitcher = switchlabel;
  }

  /**
   * 
   * Set the elements of the toggle on which the CSS classes will be applied to
   * set the material look.
   * 
   * @param eltCtnr
   *          the upper level element
   * 
   * @param eltInput
   *          the input element
   * 
   * @param eltLabel
   *          the label element
   */
  public final void setTarget(final Element eltCtnr, final Element eltInput,
      final Element eltLabel) {
    // initialize the ripple for the component
    ripple = new RippleSwitcher();
    // set the element that accepts the ripple CSS class
    ripple.setTarget(eltCtnr);
    // make the ripple disabled by default
    setRipple(Ripple.NONE);

    // each switcher is responsible for an element for which it will apply the
    // appropriate CSS class(es) when the user request the toggle to have a
    // specific material face.

    // set the the top level element for the main switcher
    mainSwitcher.setTarget(eltCtnr);

    // set the input element for the input switcher
    inputSwitcher.setTarget(eltInput);

    // set the label element for the label switcher
    labelSwitcher.setTarget(eltLabel);

    // initialize the switchers by setting the default CSS class pack (= face)
    setFace(defaultFlavor());
  }

  /**
   * Sets whether the toggle is enabled.
   * 
   * @param enable
   *          the new state of the toggle
   */
  public void setEnabled(final boolean enable) {

    Element container = mainSwitcher.getTarget();

    if (enable) {
      container.removeClassName(IS_DISABLED);
    } else {
      container.addClassName(IS_DISABLED);
    }
  }

  /**
   * Sets whether the toggle is checked.
   * 
   * @param check
   *          the new state of the toggle check
   */
  public void setValue(final boolean check) {

    Element container = mainSwitcher.getTarget();

    if (check) {
      container.removeClassName(IS_CHECKED);
    } else {
      container.addClassName(IS_CHECKED);
    }
  }

  /**
   * The sub-type must indicate the default class pack (= face) to enable the
   * component to be initialized correctly by applying at least the default face
   * for the first time.
   * 
   * @return the default flavor
   */
  protected abstract T defaultFlavor();

  /**
   * Setting a face for the toggle implies assigning a set of classes to the top
   * level element, the input element and the label element.
   * 
   * @param flavor
   *          the toggle flavor to be applied.
   */
  public void setFace(final T flavor) {
    mainSwitcher.setValue(flavor);
    inputSwitcher.setValue(flavor);
    labelSwitcher.setValue(flavor);
  }

  @Override
  public T getFace() {
    return mainSwitcher.getValue();
  }

  @Override
  public final void setRipple(final Ripple inputRipple) {
    ripple.setValue(inputRipple);
  }

  @Override
  public final Ripple getRipple() {
    return ripple.getValue();
  }

  /**
   * Apply JavaScript behaviors and effects on the component.
   */
  public void upgrade() {

    // retrieve the top level element of the component
    Element container = mainSwitcher.getTarget();

    // causes the component to be upgraded
    ComponentHandler.upgradeElement(container);

    // if the component have a ripple then also upgrade the ripple
    // container
    if (ripple.getValue() != Ripple.NONE) {

      // when the component is upgraded and has a ripple set, the upgrade
      // process will add a ripple container element as the last child of the
      // top level element. The ripple container also needs to be upgraded

      // retrieve the ripple container as the last child of the top level elt
      Element rippleContainer = (Element) container.getLastChild();

      // apply the upgrade on the ripple container
      ComponentHandler.upgradeElement(rippleContainer);
    }
  }

  /**
   * Stores the ripple option and help switch between ripple options.
   */
  private RippleSwitcher ripple;

  /**
   * a CSS switcher for the top level container.
   */
  private CssSwitcher<T> mainSwitcher;

  /**
   * a CSS switch for the input part.
   */
  private CssSwitcher<T> inputSwitcher;

  /**
   * a CSS switch for the label part.
   */
  private CssSwitcher<T> labelSwitcher;

  /**
   * CSS class applied on the root level to set whether the toggle is enabled.
   */
  private static final String IS_DISABLED = "is-disabled";
  
  /**
   * CSS class applied on the root level to set whether the toggle is checked.
   */
  private static final String IS_CHECKED = "is-checked";
}
