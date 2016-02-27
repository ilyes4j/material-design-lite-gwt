package org.zerowarning.gwt.mdl.components.buttons;

import static org.zerowarning.gwt.mdl.components.ComponentHandler.upgradeElement;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FLAT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.ICON;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.MINIFAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.RAISED;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.MdlGwtUtils;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.UIObject;

/**
 * A Material {@link Button}, can take many shapes. Its appearance is controlled
 * by a handful of properties but not all are available at the same time. For
 * example a Fab button can't have all the colors available for a Raised button.
 * Thereby, a button should not be setup using its constructor. Instead a
 * builder was implemented to assist in setting up the appropriate options for
 * the button.<br>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Button extends com.google.gwt.user.client.ui.Button {

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
   *          {@link ButtonFabColor}
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
  public static Button createFab(final ButtonFabColor color,
      final Ripple ripple, final String icon) {
    Button button = new Button();
    button.setType(FAB);
    button.setFabColor(color);
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
   *          {@link ButtonFabColor}
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
  public static Button createMiniFab(final ButtonFabColor color,
      final Ripple ripple, final String icon) {
    Button button = new Button();
    button.setType(MINIFAB);
    button.setFabColor(color);
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
    setStylePrimaryName(MDL_BTN);
    addStyleName(MDL_JS_BTN);
  }

  /**
   * Add an icon to the button.
   * 
   * @param icon
   *          a material icon font code
   */
  public final void setIcon(final String icon) {
    if (iTag == null) {
      iTag = Document.get().createElement(I_TAG);
      iTag.setClassName(MATERIAL_ICONS);
      getElement().appendChild(iTag);
    }
    iTag.setInnerHTML(icon);
  }

  /**
   * apply javascript behaviors and effects on the button.
   */
  public final void upgrade() {
    if (upgraded) {
      return;
    }

    upgradeElement(getElement());
  }

  /**
   * Return the material button type provided by one of the options in
   * {@link ButtonType}.
   * 
   * @return one of the options provided by {@link ButtonType}
   */
  public final ButtonType getType() {
    return type;
  }

  /**
   * The material button type indicates how it renders and what options can be
   * applied to tweak its appearance. The type is determined by one of the
   * options provided by {@link ButtonType}.
   * 
   * @param inputType
   *          one of the options provided by {@link ButtonType}
   */
  public final void setType(final ButtonType inputType) {
    this.type = inputType;
    addStyleName(inputType.toString());
  }

  /**
   * Returns the coloring option of the button. The returned result is
   * unpredictable if the button type is not Flat, Raised or Icon.
   * 
   * @return one of the options provided by {@link ButtonColor}
   */
  public final ButtonColor getColor() {
    return color;
  }

  /**
   * Setup the coloring option of the button. The result is unpredictable if the
   * button type is not Flat, Raised or Icon.
   * 
   * @param inputColor
   *          one of the options provided by {@link ButtonColor}
   */
  public final void setColor(final ButtonColor inputColor) {
    this.color = inputColor;
    addStyleName(inputColor.toString());
  }

  /**
   * Returns the coloring option of the button. The returned result is
   * unpredictable if the button type is not Fab or a Mini Fab.
   * 
   * @return one of the options provided by {@link ButtonFabColor}
   */
  public final ButtonFabColor getFabColor() {
    return fabColor;
  }

  /**
   * Setup the coloring option of the button. The result is unpredictable if the
   * button type is Fab or Mini Fab.
   * 
   * @param inputFabColor
   *          one of the options provided by {@link ButtonFabColor}
   */
  public final void setFabColor(final ButtonFabColor inputFabColor) {
    this.fabColor = inputFabColor;
    addStyleName(inputFabColor.toString());
  }

  /**
   * Returns the ripple option of the button.
   * 
   * @return one of the options provided by {@link Ripple}
   */
  public final Ripple getRipple() {
    return ripple;
  }

  /**
   * Setup the ripple option of the button.
   * 
   * @param inputRipple
   *          one of the options provided by {@link Ripple}
   */
  public final void setRipple(final Ripple inputRipple) {
    this.ripple = inputRipple;
    addStyleName(inputRipple.toString());
  }

  /**
   * 
   * Safely adds a new css selector to the button.
   * 
   * Should be removed and {@link MdlGwtUtils#addStyle(UIObject, Object)} should
   * be used instead.
   * 
   * @param inputStyleName
   *          the css selector to be applied safely
   */
  public final void addStyleName(final String inputStyleName) {
    if (inputStyleName == null || inputStyleName.isEmpty()) {
      return;
    }
    super.addStyleName(inputStyleName);
  }

  /**
   * Set the text to be displayed on the button.<br>
   * <br>
   * If the button is not flat nor raised, the behavior of this method is
   * unpredictable.<br>
   * <br>
   * The super type implementation of this method simply overrides anything
   * inside the button and replaces it with the text provided as input. <br>
   * <br>
   * Considering that the button element can have ripples in addition to text,
   * setting a text for the button cannot be achieved by writing over the
   * button's content. By embedding the text inside a container, it is possible
   * to target the text without damaging other context inside the button.
   * 
   * @param text
   *          the text to be set for the button
   */
  public final void setText(final String text) {

    // if the text is set for the first time
    if (textContainer == null) {

      // create a span that holds the text
      textContainer = new HTMLPanel(SpanElement.TAG, "");

      // attach the container to the button
      getElement().insertFirst(textContainer.getElement());
    }

    // set the text as the containers inner content
    textContainer.getElement().setInnerHTML(text);
  }

  /**
   * Returns the text of the button, if the button is not flat nor raised, the
   * returned value is unpredictable.
   * 
   * @return the button's text
   */
  public final String getText() {

    // if the container is not yet defined then return an undefined
    // string
    if (textContainer == null) {
      return null;
    }

    // otherwise return the content of the texte container
    return textContainer.getElement().getInnerHTML();
  }

  /**
   * The button type, whether it is fab, raised, flat...
   */
  private ButtonType type = FAB;

  /**
   * Depending on the button type, the color can affect the background, the
   * text, the icon. This property is only valid for plain, flat and icon
   * buttons.
   */
  private ButtonColor color = BTN_NO_COLOR;

  /**
   * Affects the color of a Fab button. This property is only valid for fab
   * buttons.
   */
  private ButtonFabColor fabColor = FAB_NO_COLOR;

  /**
   * Indicate whether the button has a ripple.
   */
  private Ripple ripple = NONE;

  /**
   * Indicate whether the button is already been upgraded.
   */
  private boolean upgraded = false;

  /**
   * The icon container, only used for buttons having icons.
   */
  private Element iTag;

  /**
   * Main css selector for Material Buttons styling.
   */
  private static final String MDL_BTN = "mdl-button";

  /**
   * Main css selector for Material Buttons behaviors.
   */
  private static final String MDL_JS_BTN = "mdl-js-button";

  /**
   * the i Tag type.
   */
  private static final String I_TAG = "i";

  /**
   * The material icons css selector.
   */
  private static final String MATERIAL_ICONS = "material-icons";

  /**
   * A container for the text inside a flat or raised button.
   */
  private HTMLPanel textContainer;
}
