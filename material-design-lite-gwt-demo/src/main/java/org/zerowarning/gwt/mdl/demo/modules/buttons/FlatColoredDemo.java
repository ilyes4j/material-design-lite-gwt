package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFlat;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/**
 * Flat colored buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class FlatColoredDemo implements EntryPoint {

	public void onModuleLoad() {

		final String TXT = "Button";

		// create a primary colored flat button
		get("ctnr_15").add(createFlat(PRIMARY, NONE, TXT));

		// create an accent colored flat button
		get("ctnr_16").add(createFlat(ACCENT, NONE, TXT));

		// create an accent colored flat button with a ripple
		get("ctnr_17").add(createFlat(ACCENT, HAS_RIPPLE, TXT));
	}
}