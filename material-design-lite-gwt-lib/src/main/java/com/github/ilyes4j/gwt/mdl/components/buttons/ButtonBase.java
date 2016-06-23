package com.github.ilyes4j.gwt.mdl.components.buttons;

import static com.github.ilyes4j.gwt.mdl.components.ComponentHandler.upgradeElement;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;

import com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils;
import com.github.ilyes4j.gwt.mdl.components.ripples.HasRipple;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.ripples.RippleSwitcher;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.ui.HTMLPanel;

/***
 * <p>
 * All behaviors expected from a material button are here. An instance of this
 * type is not a component of its own. Instead, it acts on a target component to
 * attach the required behaviors to it. This ensures an extra flexibility when
 * creating material buttons.
 * </p>
 * <p>
 * It wouldn't be possible to reuse the material button logic in button-like
 * components if that logic is tied to the {@link Button} component.
 * </p>
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ButtonBase implements HasRipple {

  /**
   * Setup an instance of a material button and provide the target
   * {@link Element} to be decorated with the material button behavior.
   * 
   * @param inputElement
   *          the target element to which apply the material button behavior
   */
  public ButtonBase(final Element inputElement) {
    target = inputElement;

    ripple = new RippleSwitcher();
    ripple.setTarget(target);
    ripple.setValue(Ripple.NONE);

    typeSwitcher = new ButtonTypeSwitcher();
    typeSwitcher.setTarget(target);
    typeSwitcher.setValue(ButtonType.FAB);
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
      target.appendChild(iTag);
    }
    iTag.setInnerHTML(icon);
  }

  /**
   * Apply JavaScript behaviors and effects on the button.
   */
  public final void upgrade() {
    if (upgraded) {
      return;
    }

    upgradeElement(target);
  }

  /**
   * Return the material button type provided by one of the options in
   * {@link ButtonType}.
   * 
   * @return one of the options provided by {@link ButtonType}
   */
  public final ButtonType getType() {
    return typeSwitcher.getValue();
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
    typeSwitcher.setValue(inputType);
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
    color = inputColor;
    MdlGwtUtils.addClass(target, color);
  }

  /**
   * Returns the coloring option of the button. The returned result is
   * unpredictable if the button type is not Fab or a MiniFab.
   * 
   * @return one of the options provided by {@link ButtonFabColor}
   */
  public final ButtonFabColor getFabColor() {
    return fabColor;
  }

  /**
   * Setup the coloring option of the button. The result is unpredictable if the
   * button type is Fab or MiniFab.
   * 
   * @param inputFabColor
   *          one of the options provided by {@link ButtonFabColor}
   */
  public final void setFabColor(final ButtonFabColor inputFabColor) {
    fabColor = inputFabColor;
    MdlGwtUtils.addClass(target, fabColor);
  }

  /**
   * Returns the ripple option of the button.
   * 
   * @return one of the options provided by {@link Ripple}
   */
  public final Ripple getRipple() {
    return ripple.getValue();
  }

  /**
   * Setup the ripple option of the button.
   * 
   * @param inputRipple
   *          one of the options provided by {@link Ripple}
   */
  public final void setRipple(final Ripple inputRipple) {
    ripple.setValue(inputRipple);
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
      target.insertFirst(textContainer.getElement());
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
   * CSS switcher for the button type configuration.
   */
  private ButtonTypeSwitcher typeSwitcher;

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
  private RippleSwitcher ripple;

  /**
   * Indicate whether the button is already been upgraded.
   */
  private boolean upgraded = false;

  /**
   * The icon container, only used for buttons having icons.
   */
  private Element iTag;

  /**
   * A container for the text inside a flat or raised button.
   */
  private HTMLPanel textContainer;

  /**
   * the input element.
   */
  private Element target;

  /**
   * the i Tag type.
   */
  private static final String I_TAG = "i";

  /**
   * The material icons css selector.
   */
  private static final String MATERIAL_ICONS = "material-icons";
}
