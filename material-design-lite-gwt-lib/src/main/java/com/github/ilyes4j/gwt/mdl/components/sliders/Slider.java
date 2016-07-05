package com.github.ilyes4j.gwt.mdl.components.sliders;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DragEndEvent;
import com.google.gwt.event.dom.client.DragEndHandler;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.DragEvent;
import com.google.gwt.event.dom.client.DragHandler;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.event.dom.client.GestureEndEvent;
import com.google.gwt.event.dom.client.GestureEndHandler;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
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

  @Override
  public HandlerRegistration addClickHandler(final ClickHandler handler) {
    return addDomHandler(handler, ClickEvent.getType());
  }

  @Override
  public HandlerRegistration addDoubleClickHandler(
      final DoubleClickHandler handler) {
    return addDomHandler(handler, DoubleClickEvent.getType());
  }

  @Override
  public int getTabIndex() {
    return sliderInput.getTabIndex();
  }

  @Override
  public void setAccessKey(final char key) {
    sliderInput.setAccessKey(key);
  }

  @Override
  public void setFocus(final boolean focused) {
    sliderInput.setFocus(focused);
  }

  @Override
  public void setTabIndex(final int index) {
    sliderInput.setTabIndex(index);
  }

  @Override
  public boolean isEnabled() {
    return sliderInput.isEnabled();
  }

  @Override
  public void setEnabled(final boolean enabled) {
    sliderInput.setEnabled(enabled);
  }

  @Override
  public HandlerRegistration addDragEndHandler(final DragEndHandler handler) {
    return addDomHandler(handler, DragEndEvent.getType());
  }

  @Override
  public HandlerRegistration addDragEnterHandler(
      final DragEnterHandler handler) {
    return addDomHandler(handler, DragEnterEvent.getType());
  }

  @Override
  public HandlerRegistration addDragLeaveHandler(
      final DragLeaveHandler handler) {
    return addDomHandler(handler, DragLeaveEvent.getType());
  }

  @Override
  public HandlerRegistration addDragHandler(final DragHandler handler) {
    return addDomHandler(handler, DragEvent.getType());
  }

  @Override
  public HandlerRegistration addDragOverHandler(final DragOverHandler handler) {
    return addDomHandler(handler, DragOverEvent.getType());
  }

  @Override
  public HandlerRegistration addDragStartHandler(
      final DragStartHandler handler) {
    return addDomHandler(handler, DragStartEvent.getType());
  }

  @Override
  public HandlerRegistration addDropHandler(final DropHandler handler) {
    return addDomHandler(handler, DropEvent.getType());
  }

  @Override
  public HandlerRegistration addFocusHandler(final FocusHandler handler) {
    return addDomHandler(handler, FocusEvent.getType());
  }

  @Override
  public HandlerRegistration addBlurHandler(final BlurHandler handler) {
    return addDomHandler(handler, BlurEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureStartHandler(
      final GestureStartHandler handler) {
    return addDomHandler(handler, GestureStartEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureChangeHandler(
      final GestureChangeHandler handler) {
    return addDomHandler(handler, GestureChangeEvent.getType());
  }

  @Override
  public HandlerRegistration addGestureEndHandler(
      final GestureEndHandler handler) {
    return addDomHandler(handler, GestureEndEvent.getType());
  }

  @Override
  public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
    return addDomHandler(handler, KeyUpEvent.getType());
  }

  @Override
  public HandlerRegistration addKeyDownHandler(final KeyDownHandler handler) {
    return addDomHandler(handler, KeyDownEvent.getType());
  }

  @Override
  public HandlerRegistration addKeyPressHandler(final KeyPressHandler handler) {
    return addDomHandler(handler, KeyPressEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseDownHandler(
      final MouseDownHandler handler) {
    return addDomHandler(handler, MouseDownEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseUpHandler(final MouseUpHandler handler) {
    return addDomHandler(handler, MouseUpEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOutHandler(final MouseOutHandler handler) {
    return addDomHandler(handler, MouseOutEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseOverHandler(
      final MouseOverHandler handler) {
    return addDomHandler(handler, MouseOverEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseMoveHandler(
      final MouseMoveHandler handler) {
    return addDomHandler(handler, MouseMoveEvent.getType());
  }

  @Override
  public HandlerRegistration addMouseWheelHandler(
      final MouseWheelHandler handler) {
    return addDomHandler(handler, MouseWheelEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchStartHandler(
      final TouchStartHandler handler) {
    return addDomHandler(handler, TouchStartEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchMoveHandler(
      final TouchMoveHandler handler) {
    return addDomHandler(handler, TouchMoveEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchEndHandler(final TouchEndHandler handler) {
    return addDomHandler(handler, TouchEndEvent.getType());
  }

  @Override
  public HandlerRegistration addTouchCancelHandler(
      final TouchCancelHandler handler) {
    return addDomHandler(handler, TouchCancelEvent.getType());
  }

  @Override
  public void upgrade() {
    sliderInput.upgrade();
  }

  @Override
  public boolean isUpgraded() {
    return sliderInput.isUpgraded();
  }

  /**
   * The underlying slider component.
   */
  private SliderInput sliderInput;
}
