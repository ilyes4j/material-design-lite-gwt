package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFab;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.buttons.Button;

import com.google.gwt.core.client.EntryPoint;

/**
 * Plain Fab buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class PlainFabDemo implements EntryPoint {

	public void onModuleLoad() {

		final String ICO = "add";

		// Plain fab button with an add icon
		get("ctnr_03").add(createFab(FAB_NO_COLOR, NONE, ICO));

		// Plain fab button with an add icon and ripple
		get("ctnr_04").add(createFab(FAB_NO_COLOR, HAS_RIPPLE, ICO));

		// Disabled fab button with an add icon
		Button btnFab = createFab(FAB_NO_COLOR, NONE, ICO);
		btnFab.setEnabled(false);
		get("ctnr_05").add(btnFab);
	}
}