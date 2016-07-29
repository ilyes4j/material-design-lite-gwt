package com.github.ilyes4j.gwt.mdl.components.buttons;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType.FAB;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType.FLAT;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType.ICON;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType.MINIFAB;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType.RAISED;

import com.github.ilyes4j.gwt.mdl.components.IUpgrade;
import com.github.ilyes4j.gwt.mdl.components.ripples.HasRipple;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;

/**
 * A Material {@link Button} can take many shapes. Its appearance is controlled
 * by a handful of properties but not all are available at the same time. For
 * example a Fab button can't have all the colors available for a Raised button.
 * Thereby, a button should not be setup using its constructor. Instead a
 * builder was implemented to assist in setting up the appropriate options for
 * the button.<br>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Button extends com.google.gwt.user.client.ui.Button
    implements HasRipple, IUpgrade {

  /**
   * Setup a raised material button.<br>
   * <br>
   * A raised button is a rectangular and elevated button that has a text for
   * content. It can have a ripple and one of the three available background
   * colors (translucent, primary or accented theme color).
   * 
   * @param color
   *          the background color, should be one of the options provided by
   *          {@link ButtonColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, should be one of the
   *          options provided by {@link Ripple}
   * 
   * @param text
   *          a text for the button
   * 
   * @return a raised button.
   */
  public static Button createRaised(final ButtonColor color,
      final Ripple ripple, final String text) {
    Button button = new Button();
    button.setType(RAISED);
    button.setColor(color);
    button.setRipple(ripple);
    button.setText(text);
    button.upgrade();
    return button;
  }

  /**
   * A flat button is very similar to a raised button. It uses the same options
   * as the raised button but renders differently. The provided color act on the
   * text rather than the background.
   * 
   * @param color
   *          The text color should be one of the options provided by
   *          {@link ButtonColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, should be one of the
   *          options provided by {@link Ripple}
   * 
   * @param text
   *          a text for the button
   * 
   * @return a flat button.
   */
  public static Button createFlat(final ButtonColor color, final Ripple ripple,
      final String text) {
    Button button = new Button();
    button.setType(FLAT);
    button.setColor(color);
    button.setRipple(ripple);
    button.setText(text);
    button.upgrade();
    return button;
  }

  /**
   * Setup a fab material button. <br>
   * <br>
   * A fab button is a round and elevated Button with a material icon. It can
   * have a ripple and one from only two possible background colors (translucent
   * or mdl accent theme color)
   * 
   * @param color
   *          the background color, should be one of the options provided by
   *          {@link ButtonColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param icon
   *          a material icon font code
   * 
   * @return a fab button
   */
  public static Button createFab(final ButtonColor color, final Ripple ripple,
      final String icon) {
    Button button = new Button();
    button.setType(FAB);
    button.setColor(color);
    button.setRipple(ripple);
    button.setIcon(icon);
    button.upgrade();
    return button;
  }

  /**
   * Setup an icon material button. <br>
   * <br>
   * A material icon button is at the cross road of flat and mini fab buttons.
   * 
   * @param color
   *          the icon color. Should be one of the options provided by
   *          {@link ButtonColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param icon
   *          a material icon font code
   * 
   * @return A raised button.
   */
  public static Button createIcon(final ButtonColor color, final Ripple ripple,
      final String icon) {
    Button button = new Button();
    button.setType(ICON);
    button.setColor(color);
    button.setRipple(ripple);
    button.setIcon(icon);
    button.upgrade();
    return button;
  }

  /**
   * Setup a mini fab material button. <br>
   * <br>
   * A mini fab is identical to a fab button except that it is tinier.
   * 
   * @param color
   *          the background color, should be one of the options provided by
   *          {@link ButtonColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param icon
   *          a material icon font code
   * 
   * @return A raised button.
   */
  public static Button createMiniFab(final ButtonColor color,
      final Ripple ripple, final String icon) {
    Button button = new Button();
    button.setType(MINIFAB);
    button.setColor(color);
    button.setRipple(ripple);
    button.setIcon(icon);
    button.upgrade();
    return button;
  }

  /**
   * Setup an instance by applying the basic properties shared by all material
   * buttons.
   */
  public Button() {
    base = new ButtonBase(getElement());
  }

  /**
   * @param icon
   *          a material icon font code
   * 
   * @see ButtonBase#setIcon(String)
   */
  public final void setIcon(final String icon) {
    base.setIcon(icon);
  }

  /**
   * @return one of the options provided by {@link ButtonType}
   * 
   * @see ButtonBase#getType()
   */
  public final ButtonType getType() {
    return base.getType();
  }

  /**
   * @param inputType
   *          one of the options provided by {@link ButtonType}
   * 
   * @see ButtonBase#setType(ButtonType)
   */
  public final void setType(final ButtonType inputType) {
    base.setType(inputType);
  }

  /**
   * @return one of the options provided by {@link ButtonColor}
   * 
   * @see ButtonBase#getColor()
   */
  public final ButtonColor getColor() {
    return base.getColor();
  }

  /**
   * @param inputColor
   *          one of the options provided by {@link ButtonColor}
   * 
   * @see ButtonBase#setColor(ButtonColor)
   */
  public final void setColor(final ButtonColor inputColor) {
    base.setColor(inputColor);
  }

  /**
   * @return one of the options provided by {@link Ripple}
   * 
   * @see ButtonBase#getRipple()
   */
  public final Ripple getRipple() {
    return base.getRipple();
  }

  /**
   * @param inputRipple
   *          one of the options provided by {@link Ripple}
   * 
   * @see ButtonBase#setRipple(Ripple)
   */
  public final void setRipple(final Ripple inputRipple) {
    base.setRipple(inputRipple);
  }

  /**
   * @param text
   *          the text to be set for the button
   * 
   * @see ButtonBase#setText(String)
   */
  public final void setText(final String text) {
    base.setText(text);
  }

  /**
   * @return the button's text
   * 
   * @see ButtonBase#getText()
   */
  public final String getText() {
    return base.getText();
  }

  @Override
  public final void upgrade() {
    base.upgrade();
  }

  @Override
  public boolean isUpgraded() {
    return base.isUpgraded();
  }

  /**
   * Where all material behaviors are encapsulated.
   */
  private ButtonBase base;
}
