package org.zerowarning.gwt.mdl.components.buttons;

import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonRipple.NONE;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.FLAT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.ICON;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.MINIFAB;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonType.RAISED;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * Material Button
 * 
 * @author Mohamed Ilyes Dimassi
 */
public class Button extends com.google.gwt.user.client.ui.Button {

	public static Button createRaised(ButtonColor color, ButtonRipple ripple, String text) {
		Button button = new Button();
		button.setType(RAISED);
		button.setColor(color);
		button.setRipple(ripple);
		button.setText(text);
		button.upgrade();
		return button;
	}

	public static Button createFlat(ButtonColor color, ButtonRipple ripple, String text) {
		Button button = new Button();
		button.setType(FLAT);
		button.setColor(color);
		button.setRipple(ripple);
		button.setText(text);
		button.upgrade();
		return button;
	}

	public static Button createFab(ButtonFabColor color, ButtonRipple ripple, String icon) {
		Button button = new Button();
		button.setType(FAB);
		button.setFabColor(color);
		button.setRipple(ripple);
		button.setIcon(icon);
		button.upgrade();
		return button;
	}

	public static Button createIcon(ButtonColor color, ButtonRipple ripple, String icon) {
		Button button = new Button();
		button.setType(ICON);
		button.setColor(color);
		button.setRipple(ripple);
		button.setIcon(icon);
		button.upgrade();
		return button;
	}

	public static Button createMiniFab(ButtonFabColor color, ButtonRipple ripple, String icon) {
		Button button = new Button();
		button.setType(MINIFAB);
		button.setFabColor(color);
		button.setRipple(ripple);
		button.setIcon(icon);
		button.upgrade();
		return button;
	}

	public Button() {
		setStylePrimaryName(MDL_BTN);
		addStyleName(MDL_JS_BTN);
	}

	public void setIcon(String iconName) {
		if (iTag == null) {
			iTag = Document.get().createElement(I_TAG);
			iTag.setClassName(MATERIAL_ICONS);
			getElement().appendChild(iTag);
		}
		iTag.setInnerHTML(iconName);
	}

	public void upgrade() {
		if (upgraded) {
			return;
		}

		upgradeElement(getElement());
	}

	public ButtonType getType() {
		return type;
	}

	public void setType(ButtonType type) {
		this.type = type;
		addStyleName(type.toString());
	}

	public ButtonColor getColor() {
		return color;
	}

	public void setColor(ButtonColor color) {
		this.color = color;
		addStyleName(color.toString());
	}

	public ButtonFabColor getFabColor() {
		return fabColor;
	}

	public void setFabColor(ButtonFabColor fabColor) {
		this.fabColor = fabColor;
		addStyleName(fabColor.toString());
	}

	public ButtonRipple getRipple() {
		return ripple;
	}

	public void setRipple(ButtonRipple ripple) {
		this.ripple = ripple;
		addStyleName(ripple.toString());
	}

	public boolean isUpgraded() {
		return upgraded;
	}

	public void setUpgraded(boolean upgraded) {
		this.upgraded = upgraded;
	}

	public void addStyleName(String styleName) {
		if (styleName == null || styleName.isEmpty()) {
			return;
		}
		super.addStyleName(styleName);
	}

	private native void upgradeElement(Element element)
	/*-{
		$wnd.componentHandler.upgradeElement(element);
	}-*/;

	private ButtonType type = FAB;

	private ButtonColor color = BTN_NO_COLOR;

	private ButtonFabColor fabColor = FAB_NO_COLOR;

	private ButtonRipple ripple = NONE;

	private boolean upgraded = false;

	private Element iTag;

	private static final String MDL_BTN = "mdl-button";

	private static final String MDL_JS_BTN = "mdl-js-button";

	private static final String I_TAG = "i";

	private static final String MATERIAL_ICONS = "material-icons";
}
