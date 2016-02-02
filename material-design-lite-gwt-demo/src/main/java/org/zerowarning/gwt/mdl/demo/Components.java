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

		final String BTN_CTNR = "buttonsContainer";
		
		final String TXT = "Button";
		
		final String ICO_1 = "add";
		final String ICO_2 = "info";
		final String ICO_3 = "mood";

		get(BTN_CTNR).add(createFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));
		get(BTN_CTNR).add(createFab(COLORED, HAS_RIPPLE, ICO_2));

		get(BTN_CTNR).add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(BTN_CTNR).add(createRaised(PRIMARY, HAS_RIPPLE, TXT));
		get(BTN_CTNR).add(createRaised(ACCENT, HAS_RIPPLE, TXT));

		get(BTN_CTNR).add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, TXT));
		get(BTN_CTNR).add(createFlat(PRIMARY, HAS_RIPPLE, TXT));
		get(BTN_CTNR).add(createFlat(ACCENT, HAS_RIPPLE, TXT));

		get(BTN_CTNR).add(createIcon(BTN_NO_COLOR, HAS_RIPPLE, ICO_3));
		get(BTN_CTNR).add(createIcon(PRIMARY, HAS_RIPPLE, ICO_3));
		get(BTN_CTNR).add(createIcon(ACCENT, HAS_RIPPLE, ICO_3));

		get(BTN_CTNR).add(createMiniFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));
		get(BTN_CTNR).add(createMiniFab(COLORED, HAS_RIPPLE, ICO_1));
	}
}