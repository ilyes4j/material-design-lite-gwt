package org.zerowarning.gwt.mdl;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Button;

/**
 * Material Button
 * 
 * @author Mohamed Ilyes Dimassi
 */
public class MaterialButton extends Button {
	public MaterialButton(String icon) {
		setStylePrimaryName("mdl-button");
		addStyleName("mdl-js-button");
		addStyleName("mdl-button--fab");
		addStyleName("mdl-js-ripple-effect");
		addStyleName("mdl-button--colored");

		iTag = Document.get().createElement("i");
		iTag.setClassName("material-icons");
		getElement().appendChild(iTag);

		setIcon(icon);

		upgradeElement(getElement());
	}

	public native void upgradeElement(Element element)
	/*-{
		$wnd.componentHandler.upgradeElement(element);
	}-*/;

	public void setIcon(String iconName) {
		iTag.setInnerHTML(iconName);
	}

	private Element iTag;
}
