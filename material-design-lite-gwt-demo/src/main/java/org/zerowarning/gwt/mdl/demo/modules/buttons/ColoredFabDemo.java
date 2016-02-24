package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFab;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/**
 * Colored Fab buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ColoredFabDemo implements EntryPoint {

	public void onModuleLoad() {

		final String ICO = "add";

		// colored fab button with an add icon
		get("ctnr_01").add(createFab(COLORED, NONE, ICO));

		// colored fab button with an add icon and ripple
		get("ctnr_02").add(createFab(COLORED, HAS_RIPPLE, ICO));
	}
}