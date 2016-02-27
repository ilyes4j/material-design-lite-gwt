package org.zerowarning.gwt.mdl.extensions.buttons;

import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.ICON;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.MINIFAB;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.user.client.ui.Image;

/**
 * A Material Fab and Icon button that has an {@link Image} instead of a
 * material icon.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ImgButton extends Button {

  /**
   * Setup the button.
   */
  public ImgButton() {
    super();
    addStyleName(IMG_BTN_RESET);
  }

  /**
   * Setup a fab button.
   * 
   * @param color
   *          the background color, should be one of the options provided by
   *          {@link ButtonFabColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param img
   *          the icon to be set for the button
   * 
   * @return a fab button
   * 
   * @see Button#createFab(ButtonFabColor, Ripple, String)
   */
  public static Button createFabI(final ButtonFabColor color,
      final Ripple ripple, final Image img) {
    ImgButton button = new ImgButton();
    button.setType(FAB);
    button.setFabColor(color);
    button.setRipple(ripple);
    button.setImage(img);
    button.upgrade();
    return button;
  }

  /**
   * Setup an icon button. <br>
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param img
   *          a material icon font code
   * 
   * @return an icon button
   * 
   * @see Button#createIcon(ButtonColor, Ripple, String)
   */
  public static Button createIconI(final Ripple ripple, final Image img) {
    ImgButton button = new ImgButton();
    button.setType(ICON);
    button.setColor(BTN_NO_COLOR);
    button.setRipple(ripple);
    button.setImage(img);
    button.upgrade();
    return button;
  }

  /**
   * Setup a mini fab material button.
   * 
   * @param color
   *          the background color, should be one of the options provided by
   *          {@link ButtonFabColor}
   * 
   * @param ripple
   *          determines whether the button has a ripple, one of the options
   *          provided by {@link Ripple}
   * 
   * @param img
   *          a material icon font code
   * 
   * @return A mini baf button
   * 
   * @see Button#createMiniFab(ButtonFabColor, Ripple, String)
   */
  public static Button createMiniFabI(final ButtonFabColor color,
      final Ripple ripple, final Image img) {
    ImgButton button = new ImgButton();
    button.setType(MINIFAB);
    button.setFabColor(color);
    button.setRipple(ripple);
    button.setImage(img);
    button.upgrade();
    return button;
  }

  /**
   * Sets an image for the button.
   * 
   * @param img
   *          the image that will be placed at the center of the button
   */
  public final void setImage(final Image img) {
    getElement().appendChild(img.getElement());
  }

  /**
   * The main css selector for material buttons with images.
   */
  private static final String IMG_BTN_RESET = "mdl-img-button";
}
