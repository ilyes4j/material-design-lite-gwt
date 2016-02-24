package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createIcon;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/**
 * Icon buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class IconButtonDemo implements EntryPoint {

	public void onModuleLoad() {

		final String ICO = "mood";

		// create an icon button
		get("ctnr_18").add(createIcon(BTN_NO_COLOR, NONE, ICO));

		// create a colored icon button
		get("ctnr_19").add(createIcon(PRIMARY, NONE, ICO));

		// create an accent colored icon button
		get("ctnr_20").add(createIcon(ACCENT, NONE, ICO));

		// create an accent colored icon button with ripple
		get("ctnr_21").add(createIcon(ACCENT, HAS_RIPPLE, ICO));
	}
}