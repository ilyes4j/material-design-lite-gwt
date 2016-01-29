package org.zerowarning.gwt.mdl.demo;

import static com.google.gwt.core.client.GWT.getModuleBaseURL;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonRipple.RIPPLE;
import static org.zerowarning.gwt.mdl.exts.components.buttons.ImgButton.createFabI;

import org.zerowarning.gwt.mdl.exts.components.menu.SelectBox;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Mohamed Ilyes Dimassi
 */
public class Extensions implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel extensPanel = RootPanel.get("extensContainer");

		String url = getModuleBaseURL() + "ic_info_black_24dp_1x.png";
		Image img = new Image(url);
		extensPanel.add(createFabI(COLORED, RIPPLE, img));

		SelectBox btn = new SelectBox();
		extensPanel.add(btn);
	}
}