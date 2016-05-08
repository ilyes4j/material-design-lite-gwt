package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A {@link SliderInput} cannot be resized if it sits on its own. A
 * {@link SliderInput} needs to be wrapped in a container to which the size is
 * applied.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Slider extends FlowPanel implements ISlider {

  /**
   * Setup the slider.
   */
  public Slider() {
    sliderInput = new SliderInput();
    add(sliderInput);
  }

  @Override
  public HandlerRegistration addInputHandler(final InputHandler handler) {
    return sliderInput.addInputHandler(handler);
  }

  @Override
  public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
    return sliderInput.addChangeHandler(handler);
  }

  @Override
  public double getValue() {
    return sliderInput.getValue();
  }

  @Override
  public void setValue(final double value) {
    sliderInput.setValue(value);
  }

  @Override
  public double getMin() {
    return sliderInput.getMin();
  }

  @Override
  public void setMin(final double minimum) {
    sliderInput.setMin(minimum);
  }

  @Override
  public double getMax() {
    return sliderInput.getMax();
  }

  @Override
  public void setMax(final double maximum) {
    sliderInput.setMax(maximum);
  }

  @Override
  public void setStep(final double step) {
    sliderInput.setStep(step);
  }

  @Override
  public double getStep() {
    return sliderInput.getStep();
  }

  @Override
  public void removeStep() {
    sliderInput.removeStep();
  }

  @Override
  public String toString() {
    return sliderInput.toString();
  }

  /**
   * The underlying slider component.
   */
  private SliderInput sliderInput;
}
