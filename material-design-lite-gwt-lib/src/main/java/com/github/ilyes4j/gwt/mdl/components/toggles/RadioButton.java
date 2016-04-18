package com.github.ilyes4j.gwt.mdl.components.toggles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

/**
 * A mutually-exclusive selection radio button widget. Fires
 * {@link com.google.gwt.event.dom.client.ClickEvent ClickEvents} when the radio
 * button is clicked, and {@link ValueChangeEvent ValueChangeEvents} when the
 * button becomes checked. Note, however, that browser limitations prevent
 * ValueChangeEvents from being sent when the radio button is cleared as a side
 * effect of another in the group being clicked.
 * 
 *
 * <p>
 * <h3>Built-in Bidi Text Support</h3> This widget is capable of automatically
 * adjusting its direction according to its content. This feature is controlled
 * by {@link #setDirectionEstimator} or passing a DirectionEstimator parameter
 * to the constructor, and is off by default.
 * </p>
 * 
 */
public class RadioButton extends CheckboxBase<RadioStyle> {

  /**
   * Creates a new radio associated with a particular group name. All radio
   * buttons associated with the same group name belong to a mutually-exclusive
   * set.
   * 
   * Radio buttons are grouped by their name attribute, so changing their name
   * using the setName() method will also change their associated group.
   * 
   * @param name
   *          the group name with which to associate the radio button
   */
  @UiConstructor
  public RadioButton(final String name) {
    super(Document.get().createRadioInputElement(name),
        new RadioStyleOperator());

    sinkEvents(Event.ONCLICK);
    sinkEvents(Event.ONMOUSEUP);
    sinkEvents(Event.ONBLUR);
    sinkEvents(Event.ONKEYDOWN);
  }

  /**
   * Creates a new radio associated with a particular group, and initialized
   * with the given HTML label. All radio buttons associated with the same group
   * name belong to a mutually-exclusive set.
   * 
   * Radio buttons are grouped by their name attribute, so changing their name
   * using the setName() method will also change their associated group.
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's html label
   */
  public RadioButton(final String name, final SafeHtml label) {
    this(name, label.asString(), true);
  }

  /**
   * @see #RadioButton(String, SafeHtml)
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's html label
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   */
  public RadioButton(final String name, final SafeHtml label,
      final Direction dir) {
    this(name);
    setHTML(label, dir);
  }

  /**
   * @see #RadioButton(String, SafeHtml)
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's html label
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   */
  public RadioButton(final String name, final SafeHtml label,
      final DirectionEstimator directionEstimator) {
    this(name);
    setDirectionEstimator(directionEstimator);
    setHTML(label.asString());
  }

  /**
   * Creates a new radio associated with a particular group, and initialized
   * with the given HTML label. All radio buttons associated with the same group
   * name belong to a mutually-exclusive set.
   * 
   * Radio buttons are grouped by their name attribute, so changing their name
   * using the setName() method will also change their associated group.
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's label
   */
  public RadioButton(final String name, final String label) {
    this(name);
    setText(label);
  }

  /**
   * @see #RadioButton(String, SafeHtml)
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's label
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   */
  public RadioButton(final String name, final String label,
      final Direction dir) {
    this(name);
    setText(label, dir);
  }

  /**
   * @see #RadioButton(String, SafeHtml)
   * 
   * @param name
   *          the group name with which to associate the radio button
   * @param label
   *          this radio button's label
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   */
  public RadioButton(final String name, final String label,
      final DirectionEstimator directionEstimator) {
    this(name);
    setDirectionEstimator(directionEstimator);
    setText(label);
  }

  /**
   * Creates a new radio button associated with a particular group, and
   * initialized with the given label (optionally treated as HTML). All radio
   * buttons associated with the same group name belong to a mutually-exclusive
   * set.
   * 
   * Radio buttons are grouped by their name attribute, so changing their name
   * using the setName() method will also change their associated group.
   * 
   * @param name
   *          name the group with which to associate the radio button
   * @param label
   *          this radio button's label
   * @param asHTML
   *          <code>true</code> to treat the specified label as HTML
   */
  public RadioButton(final String name, final String label,
      final boolean asHTML) {
    this(name);
    if (asHTML) {
      setHTML(label);
    } else {
      setText(label);
    }
  }

  /**
   * Overridden to send ValueChangeEvents only when appropriate.
   */
  @Override
  public void onBrowserEvent(final Event event) {
    switch (DOM.eventGetType(event)) {
    case Event.ONMOUSEUP:
    case Event.ONBLUR:
    case Event.ONKEYDOWN:
      // Note the old value for onValueChange purposes (in ONCLICK case)
      oldValue = getValue();
      break;

    case Event.ONCLICK:
      EventTarget target = event.getEventTarget();
      if (Element.is(target) && getLabel().isOrHasChild(Element.as(target))) {

        // They clicked the label. Note our pre-click value, and
        // short circuit event routing so that other click handlers
        // don't hear about it
        oldValue = getValue();
        return;
      }

      // It's not the label. Let our handlers hear about the
      // click...
      super.onBrowserEvent(event);
      // ...and now maybe tell them about the change
      ValueChangeEvent.fireIfNotEqual(RadioButton.this, oldValue, getValue());
      return;
    default:
      return;
    }

    super.onBrowserEvent(event);
  }

  /**
   * Change the group name of this radio button.
   * 
   * Radio buttons are grouped by their name attribute, so changing their name
   * using the setName() method will also change their associated group.
   * 
   * If changing this group name results in a new radio group with multiple
   * radio buttons selected, this radio button will remain selected and the
   * other radio buttons will be unselected.
   * 
   * @param name
   *          name the group with which to associate the radio button
   */
  @Override
  public void setName(final String name) {
    // Just changing the radio button name tends to break groupiness,
    // so we have to replace it. Note that replaceInputElement is careful
    // not to propagate name when it propagates everything else
    replaceInputElement(Document.get().createRadioInputElement(name));
  }

  /**
   * No-op. CheckBox's click handler is no good for radio button, so don't use
   * it. Our event handling is all done in {@link #onBrowserEvent}
   */
  @Override
  protected void ensureDomEventHandlers() {
  }

  /**
   * The previous state value of the radio button.
   */
  private Boolean oldValue;
}
