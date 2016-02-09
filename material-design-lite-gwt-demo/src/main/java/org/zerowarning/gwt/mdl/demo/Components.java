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

import org.zerowarning.gwt.mdl.components.buttons.Button;

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
		final String CTNR_4 = "ctnr_4";
		final String CTNR_5 = "ctnr_5";
		final String CTNR_6 = "ctnr_6";
		final String CTNR_7 = "ctnr_7";
		final String CTNR_8 = "ctnr_8";
		final String CTNR = "ctnr";

		final String TXT = "Button";
		final String ICO_1 = "add";
		final String ICO_3 = "mood";

		// colored fab button with an add icon
		get(CTNR_1).add(createFab(COLORED, NONE, ICO_1));

		// colored fab button with an add icon and ripple
		get(CTNR_2).add(createFab(COLORED, HAS_RIPPLE, ICO_1));

		// Plain fab button with an add icon
		get(CTNR_3).add(createFab(FAB_NO_COLOR, NONE, ICO_1));

		// Plain fab button with an add icon and ripple
		get(CTNR_4).add(createFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));

		// Disabled fab button with an add icon
		Button btnFab = createFab(FAB_NO_COLOR, NONE, ICO_1);
		btnFab.setEnabled(false);
		get(CTNR_5).add(btnFab);

		//create a plain raised button
		get(CTNR_6).add(createRaised(BTN_NO_COLOR, NONE, TXT));
		
		//create a plain raised button with ripple
		get(CTNR_7).add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		
		//create a plain raised disabled button
		Button btnRaised = createRaised(BTN_NO_COLOR, NONE, TXT);
		btnRaised.setEnabled(false);
		get(CTNR_8).add(btnRaised);
		
		get(CTNR).add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(CTNR).add(createRaised(PRIMARY, HAS_RIPPLE, TXT));
		get(CTNR).add(createRaised(ACCENT, HAS_RIPPLE, TXT));

		get(CTNR).add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(CTNR).add(createFlat(PRIMARY, HAS_RIPPLE, TXT));
		get(CTNR).add(createFlat(ACCENT, HAS_RIPPLE, TXT));

		get(CTNR).add(createIcon(BTN_NO_COLOR, HAS_RIPPLE, ICO_3));
		get(CTNR).add(createIcon(PRIMARY, HAS_RIPPLE, ICO_3));
		get(CTNR).add(createIcon(ACCENT, HAS_RIPPLE, ICO_3));

		get(CTNR).add(createMiniFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));
		get(CTNR).add(createMiniFab(COLORED, HAS_RIPPLE, ICO_1));
	}
}