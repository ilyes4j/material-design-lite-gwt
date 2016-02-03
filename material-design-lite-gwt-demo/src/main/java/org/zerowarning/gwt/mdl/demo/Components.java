package org.zerowarning.gwt.mdl.demo;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFab;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createFlat;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createIcon;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createMiniFab;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.FAB_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/**
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Components implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String CTNR_1 = "ctnr_1";
		final String CTNR_2 = "ctnr_2";
		final String CTNR_3 = "ctnr_3";

		final String TXT = "Button";
		final String ICO_1 = "add";
		final String ICO_3 = "mood";

		// colored fab button with an add icon
		get(CTNR_1).add(createFab(COLORED, NONE, ICO_1));

		// colored fab button with an add icon and ripples
		get(CTNR_2).add(createFab(COLORED, HAS_RIPPLE, ICO_1));

		get(CTNR_3).add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(CTNR_3).add(createRaised(PRIMARY, HAS_RIPPLE, TXT));
		get(CTNR_3).add(createRaised(ACCENT, HAS_RIPPLE, TXT));

		get(CTNR_3).add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(CTNR_3).add(createFlat(PRIMARY, HAS_RIPPLE, TXT));
		get(CTNR_3).add(createFlat(ACCENT, HAS_RIPPLE, TXT));

		get(CTNR_3).add(createIcon(BTN_NO_COLOR, HAS_RIPPLE, ICO_3));
		get(CTNR_3).add(createIcon(PRIMARY, HAS_RIPPLE, ICO_3));
		get(CTNR_3).add(createIcon(ACCENT, HAS_RIPPLE, ICO_3));

		get(CTNR_3).add(createMiniFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));
		get(CTNR_3).add(createMiniFab(COLORED, HAS_RIPPLE, ICO_1));
	}
}