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
import org.zerowarning.gwt.mdl.demo.utils.DemoUtils;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT module for the buttons demo page.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ButtonDemo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String CTNR_01 = "ctnr_01";
		final String CTNR_02 = "ctnr_02";
		final String CTNR_03 = "ctnr_03";
		final String CTNR_04 = "ctnr_04";
		final String CTNR_05 = "ctnr_05";
		final String CTNR_06 = "ctnr_06";
		final String CTNR_07 = "ctnr_07";
		final String CTNR_08 = "ctnr_08";
		final String CTNR_09 = "ctnr_09";
		final String CTNR_10 = "ctnr_10";
		final String CTNR_11 = "ctnr_11";
		final String CTNR_12 = "ctnr_12";
		final String CTNR_13 = "ctnr_13";
		final String CTNR_14 = "ctnr_14";
		final String CTNR_15 = "ctnr_15";
		final String CTNR_16 = "ctnr_16";
		final String CTNR_17 = "ctnr_17";
		final String CTNR_18 = "ctnr_18";
		final String CTNR_19 = "ctnr_19";
		final String CTNR_20 = "ctnr_20";
		final String CTNR_21 = "ctnr_21";
		final String CTNR_22 = "ctnr_22";
		final String CTNR_23 = "ctnr_23";

		final String TXT = "Button";
		final String ICO_1 = "add";
		final String ICO_3 = "mood";

		// colored fab button with an add icon
		get(CTNR_01).add(createFab(COLORED, NONE, ICO_1));

		// colored fab button with an add icon and ripple
		get(CTNR_02).add(createFab(COLORED, HAS_RIPPLE, ICO_1));

		// Plain fab button with an add icon
		get(CTNR_03).add(createFab(FAB_NO_COLOR, NONE, ICO_1));

		// Plain fab button with an add icon and ripple
		get(CTNR_04).add(createFab(FAB_NO_COLOR, HAS_RIPPLE, ICO_1));

		// Disabled fab button with an add icon
		Button btnFab = createFab(FAB_NO_COLOR, NONE, ICO_1);
		btnFab.setEnabled(false);
		get(CTNR_05).add(btnFab);

		// create a plain raised button
		get(CTNR_06).add(createRaised(BTN_NO_COLOR, NONE, TXT));

		// create a plain raised button with ripple
		get(CTNR_07).add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));

		// create a plain raised disabled button
		Button btnRaised = createRaised(BTN_NO_COLOR, NONE, TXT);
		btnRaised.setEnabled(false);
		get(CTNR_08).add(btnRaised);

		// create a colored button with a ripple
		get(CTNR_09).add(createRaised(PRIMARY, NONE, TXT));

		// create an accent colored button
		get(CTNR_10).add(createRaised(ACCENT, NONE, TXT));

		// create an accent colored button with a ripple
		get(CTNR_11).add(createRaised(ACCENT, HAS_RIPPLE, TXT));

		// create a flat button
		get(CTNR_12).add(createFlat(BTN_NO_COLOR, NONE, TXT));

		// create a flat button with a ripple
		get(CTNR_13).add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, TXT));

		// create disabled flat button
		Button btnFlat = createFlat(BTN_NO_COLOR, NONE, TXT);
		btnFlat.setEnabled(false);
		get(CTNR_14).add(btnFlat);

		// create a primary colored flat button
		get(CTNR_15).add(createFlat(PRIMARY, NONE, TXT));

		// create an accent colored flat button
		get(CTNR_16).add(createFlat(ACCENT, NONE, TXT));

		// create an accent colored flat button with a ripple
		get(CTNR_17).add(createFlat(ACCENT, HAS_RIPPLE, TXT));

		// create an icon button
		get(CTNR_18).add(createIcon(BTN_NO_COLOR, NONE, ICO_3));

		// create a colored icon button
		get(CTNR_19).add(createIcon(PRIMARY, NONE, ICO_3));

		// create an accent colored icon button
		get(CTNR_20).add(createIcon(ACCENT, NONE, ICO_3));

		// create an accent colored icon button with ripple
		get(CTNR_21).add(createIcon(ACCENT, HAS_RIPPLE, ICO_3));

		// create a mini fab
		get(CTNR_22).add(createMiniFab(FAB_NO_COLOR, NONE, ICO_1));

		// create a colored mini fab
		get(CTNR_23).add(createMiniFab(COLORED, NONE, ICO_1));

		DemoUtils.insertMainbar();
		DemoUtils.insertComponentsNavbar();
	}
}