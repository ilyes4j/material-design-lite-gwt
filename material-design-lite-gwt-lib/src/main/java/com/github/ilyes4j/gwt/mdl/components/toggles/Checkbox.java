package com.github.ilyes4j.gwt.mdl.components.toggles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * A check box is a material component that provides all the features already
 * found in the regular GWT {@link CheckBox} Widget. A material check box can
 * have three different faces. To set the most suitable face the
 * {@link Checkbox#setFace(CheckBoxStyle)} should be used.
 * <ul>
 * <li>{@link CheckBoxStyle#CHECKBOX} to set the check box face</li>
 * <li>{@link CheckBoxStyle#SWITCH} to set the switch face</li>
 * <li>{@link CheckBoxStyle#ICON} to set the icon face</li>
 * </ul>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Checkbox extends CheckboxBase<CheckBoxStyle>
    implements IToggleFace<CheckBoxStyle> {

  /**
   * Creates a check box with no label.
   */
  public Checkbox() {
    super(Document.get().createCheckInputElement(),
        new CheckBoxStyleOperator());
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   */
  public Checkbox(final SafeHtml label) {
    super(label, new CheckBoxStyleOperator());
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
  public Checkbox(final SafeHtml label, final Direction dir) {
    super(label, dir, new CheckBoxStyleOperator());
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment. For convenience, {@link #DEFAULT_DIRECTION_ESTIMATOR}
   *          can be used.
   */
  public Checkbox(final SafeHtml label,
      final DirectionEstimator directionEstimator) {
    super(label, directionEstimator, new CheckBoxStyleOperator());
  }

  /**
   * Creates a check box with the specified text label.
   * 
   * @param label
   *          the check box's label
   */
  public Checkbox(final String label) {
    super(label, new CheckBoxStyleOperator());
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
  public Checkbox(final String label, final Direction dir) {
    super(label, dir, new CheckBoxStyleOperator());
  }

  /**
   * Creates a label with the specified text and a default direction estimator.
   * 
   * @param label
   *          the check box's label
   * 
   * @param directionEstimator
   *          A DirectionEstimator object used for automatic direction
   *          adjustment. For convenience, {@link #DEFAULT_DIRECTION_ESTIMATOR}
   *          can be used.
   */
  public Checkbox(final String label,
      final DirectionEstimator directionEstimator) {
    super(label, directionEstimator, new CheckBoxStyleOperator());
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
  public Checkbox(final String label, final boolean asHTML) {
    super(new CheckBoxStyleOperator());
  }

  /**
   * @param elem
   *          the input element
   */
  protected Checkbox(final Element elem) {
    super(elem, new CheckBoxStyleOperator());
  }

  @Override
  public CheckBoxStyle getFace() {
    return getToggle().getFace();
  }

  @Override
  public void setFace(final CheckBoxStyle flavor) {
    getToggle().setFace(flavor);
  }
}
