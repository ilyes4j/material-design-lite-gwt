package org.zerowarning.gwt.mdl.extensions.buttons;

import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.ICON;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.MINIFAB;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.buttons.ButtonColor;
import org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor;
import org.zerowarning.gwt.mdl.components.ripples.Ripple;

import com.google.gwt.user.client.ui.Image;

public class ImgButton extends Button {

	public ImgButton() {
		super();
		addStyleName(IMG_BTN_RESET);
	}

	public static Button createFabI(ButtonFabColor color, Ripple ripple, Image img) {
		ImgButton button = new ImgButton();
		button.setType(FAB);
		button.setFabColor(color);
		button.setRipple(ripple);
		button.setImage(img);
		button.upgrade();
		return button;
	}

	public static Button createIconI(ButtonColor color, Ripple ripple, Image img) {
		ImgButton button = new ImgButton();
		button.setType(ICON);
		button.setColor(color);
		button.setRipple(ripple);
		button.setImage(img);
		button.upgrade();
		return button;
	}

	public static Button createMiniFabI(ButtonFabColor color, Ripple ripple, Image img) {
		ImgButton button = new ImgButton();
		button.setType(MINIFAB);
		button.setFabColor(color);
		button.setRipple(ripple);
		button.setImage(img);
		button.upgrade();
		return button;
	}

	public void setImage(Image img) {
		getElement().appendChild(img.getElement());
	}

	private static final String IMG_BTN_RESET = "mdl-img-button";
}
