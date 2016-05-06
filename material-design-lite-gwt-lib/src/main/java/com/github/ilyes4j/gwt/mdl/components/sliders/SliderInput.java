package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.github.ilyes4j.gwt.mdl.components.ComponentHandler;
import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FocusWidget;

/**
 * The slider component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class SliderInput extends FocusWidget implements ISlider {

  /**
   * Create the slider input element using javascript.
   * 
   * @param doc
   *          the GWT encapsulation of document
   * 
   * @return the created input element
   */
  public static native InputElement createRangeInputElement(final Document doc)
  /*-{
    var e = doc.createElement("INPUT");
    e.type = 'range';
    return e;
  }-*/;

  /**
   * Setup the slider component.
   */
  public SliderInput() {

    super(createRangeInputElement(Document.get()));

    inputElem = (InputElement) (Element) getElement();

    addStyleName("mdl-slider mdl-js-slider");

    setMin(DEFAULT_MIN);
    setMax(DEFAULT_MAX);
    setValue(DEFAULT_VAL);
  }

  @Override
  public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
    return addDomHandler(handler, ChangeEvent.getType());
  }

  @Override
  public double getValue() {
    return MdlGwtUtils.getProperty(getElement(), VAL);
  }

  @Override
  public void setValue(final double value) {
    MdlGwtUtils.setProperty(getElement(), VAL, value);
  }

  @Override
  public double getMin() {
    return getAttr(MIN);
  }

  @Override
  public void setMin(final double minimum) {
    setAttr(MIN, minimum);
  }

  @Override
  public double getMax() {
    return Double.parseDouble(getElement().getAttribute(MAX));
  }

  @Override
  public void setMax(final double maximum) {
    setAttr(MAX, maximum);
  }

  @Override
  public void setStep(final double step) {
    setAttr(STEP, step);
  }

  @Override
  public double getStep() {
    return getAttr(STEP);
  }

  @Override
  public void removeStep() {
    getElement().removeAttribute(STEP);
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append("min : ");
    sb.append(String.valueOf(getMin()));

    sb.append(", max : ");
    sb.append(String.valueOf(getMax()));

    sb.append(", val : ");
    sb.append(String.valueOf(getValue()));

    return sb.toString();
  }

  @Override
  protected void onLoad() {
    super.onLoad();

    ComponentHandler.upgradeElement(getElement());
  }

  /**
   * @param prop
   *          the property name to set a value to
   * 
   * @return the value for the property
   */
  private double getAttr(final String prop) {
    return Double.parseDouble(getElement().getAttribute(prop));
  }

  /**
   * @param prop
   *          the property to be set
   * 
   * @param val
   *          the value to be applied for the property
   */
  private void setAttr(final String prop, final double val) {
    getElement().setAttribute(prop, String.valueOf(val));
  }

  /**
   * the input element.
   */
  private InputElement inputElem;

  /**
   * The property name of minimum edge.
   */
  private static final String MIN = "min";

  /**
   * The property name of maximum edge.
   */
  private static final String MAX = "max";

  /**
   * The property name of the current value.
   */
  private static final String VAL = "value";

  /**
   * The property name of the step size.
   */
  private static final String STEP = "step";

  /**
   * Default maximum value for the range.
   */
  private static final int DEFAULT_MIN = 0;

  /**
   * Default maximum value for the range.
   */
  private static final int DEFAULT_MAX = 100;

  /**
   * Default initial value set on the range.
   */
  private static final int DEFAULT_VAL = 0;
}
