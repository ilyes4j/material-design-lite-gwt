package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * The slider component contract.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface ISlider {

  /**
   * Adds a {@link InputHandler} handler.
   * 
   * @param handler
   *          the input handler
   * 
   * @return {@link HandlerRegistration} used to remove this handler
   */
  HandlerRegistration addInputHandler(final InputHandler handler);

  /**
   * Adds a {@link ChangeHandler} handler.
   * 
   * @param handler
   *          the chnage handler
   * 
   * @return {@link HandlerRegistration} used to remove this handler
   */
  HandlerRegistration addChangeHandler(final ChangeHandler handler);

  /**
   * @return the current value of the slider
   */
  double getValue();

  /**
   * @param value
   *          the current value in the range
   */
  void setValue(final double value);

  /**
   * @return the minimum value for the range.
   */
  double getMin();

  /**
   * @param minimum
   *          the minimum value in the range
   */
  void setMin(final double minimum);

  /**
   * @return the maximum value for the range.
   */
  double getMax();

  /**
   * @param maximum
   *          the maximum value in the range
   */
  void setMax(final double maximum);

  /**
   * @param step
   *          the size of a leap in a discrete range.
   */
  void setStep(final double step);

  /**
   * @return the size of a leap in a discrete range.
   */
  double getStep();

  /**
   * Removes the step property if it is set.
   */
  void removeStep();
}
