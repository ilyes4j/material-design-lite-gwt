package org.zerowarning.gwt.mdl.demo;

import static com.google.gwt.core.client.GWT.getModuleBaseURL;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.exts.components.buttons.ImgButton.createFabI;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.Menu;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Extensions implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel extensPanel = RootPanel.get("extensContainer");

		Menu menu = new Menu("select");
		menu.getElement().setAttribute("style", "padding-right: 4px;");
		extensPanel.add(menu);

		String url = getModuleBaseURL() + "ic_info_black_24dp_1x.png";
		Image img = new Image(url);
		Button btn = createFabI(COLORED, HAS_RIPPLE, img);
		btn.setEnabled(false);
		extensPanel.add(btn);
	}
}