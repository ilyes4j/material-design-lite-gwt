package com.github.ilyes4j.gwt.mdl.extensions.flips;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColorSwitcher;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckboxBase;
import com.github.ilyes4j.gwt.mdl.components.toggles.IToggleFace;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * A Flip is not an official mdl component but a cross breeding between a button
 * and a toggle. A flip is a toggle with the look of button. It behaves exactly
 * as the the Checkbox while providing the visual appearance of a button.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Flip extends CheckboxBase<ButtonType>
    implements IToggleFace<ButtonType> {

  /**
   * Creates a check box with no label.
   */
  public Flip() {
    super(Document.get().createCheckInputElement(), new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   */
  public Flip(final SafeHtml label) {
    super(label, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   */
  public Flip(final SafeHtml label, final Direction dir) {
    super(label, dir, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   */
  public Flip(final SafeHtml label,
      final DirectionEstimator directionEstimator) {
    super(label, directionEstimator, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   */
  public Flip(final String label) {
    super(label, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param dir
   *          the text's direction. Note that {@code DEFAULT} means direction
   *          should be inherited from the widget's parent element.
   */
  public Flip(final String label, final Direction dir) {
    super(label, dir, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a label with the specified text and a default direction estimator.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment.
   */
  public Flip(final String label, final DirectionEstimator directionEstimator) {
    super(label, directionEstimator, new FlipStyleOperator());
    init();
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param asHTML
   *          <code>true</code> to treat the specified label as html
   */
  public Flip(final String label, final boolean asHTML) {
    super(new FlipStyleOperator());
    init();
  }

  /**
   * @param elem
   *          the input element
   */
  protected Flip(final Element elem) {
    super(elem, new FlipStyleOperator());
    init();
  }

  @Override
  public ButtonType getFace() {
    return getToggle().getFace();
  }

  @Override
  public void setFace(final ButtonType flavor) {
    getToggle().setFace(flavor);
  }

  @Override
  public void setValue(final Boolean value) {
    // the setValue is overloaded to apply the appropriate color when the flip
    // is pushed

    // perform the default behavior
    super.setValue(value);

    // apply the the appropriate color on the toggle
    setStyle();
  }

  /**
   * Specify the color to be applied when the flip is in the unchecked state.
   * 
   * @param checked
   *          the color option to be applied when the flip is checked
   */
  public void setCheckedColor(final ButtonColor checked) {
    checkedColor = checked;
    setStyle();
  }

  /**
   * @return the color option applied when the flip is checked
   */
  public ButtonColor getCheckedColor() {
    return checkedColor;
  }

  /**
   * Specify the color to be applied when the flip is in the checked state.
   * 
   * @param unchecked
   *          the color option to be applied when the flip is unchecked
   */
  public void setUncheckedColor(final ButtonColor unchecked) {
    uncheckedColor = unchecked;
    setStyle();
  }

  /**
   * @return the color option applied when the flip is unchecked
   */
  public ButtonColor getUncheckedColor() {
    return uncheckedColor;
  }

  /**
   * Apply the accent style when the the flip is down.
   */
  private void init() {

    // by default the flip has a translucent (no color) when unchecked
    uncheckedColor = ButtonColor.BTN_NO_COLOR;

    // by default the flip has an accent color when checked
    checkedColor = ButtonColor.ACCENT;

    // setup the switcher that handles the application of a color to the flip
    colorSwitcher = new ButtonColorSwitcher();
    colorSwitcher.setTarget(getContainer());

    // apply color configuration on instantiation
    setStyle();

    // listen for value change and "flip" the color accordingly
    addValueChangeHandler(new ValueChangeHandler<Boolean>() {
      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        // apply color on value change
        setStyle();
      }
    });
  }

  /**
   * refresh the style of the button according to the current state of the
   * toggle.
   */
  private void setStyle() {
    colorSwitcher.setValue(getValue() ? checkedColor : uncheckedColor);
  }

  /**
   * manages the application of color to the button.
   */
  private ButtonColorSwitcher colorSwitcher;

  /**
   * The color to be applied when the toggle is checked.
   */
  private ButtonColor checkedColor;

  /**
   * The color to be applied when the toggle is unchecked.
   */
  private ButtonColor uncheckedColor;
}
