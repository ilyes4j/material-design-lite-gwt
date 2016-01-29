package org.zerowarning.gwt.mdl.demo;

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
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Components implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel buttonsPanel = RootPanel.get("buttonsContainer");

		buttonsPanel.add(createFab(FAB_NO_COLOR, HAS_RIPPLE, "add"));
		buttonsPanel.add(createFab(COLORED, HAS_RIPPLE, "info"));

		buttonsPanel.add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Button"));
		buttonsPanel.add(createRaised(PRIMARY, HAS_RIPPLE, "Button"));
		buttonsPanel.add(createRaised(ACCENT, HAS_RIPPLE, "Button"));

		buttonsPanel.add(createFlat(BTN_NO_COLOR, HAS_RIPPLE, "Button"));
		buttonsPanel.add(createFlat(PRIMARY, HAS_RIPPLE, "Button"));
		buttonsPanel.add(createFlat(ACCENT, HAS_RIPPLE, "Button"));

		buttonsPanel.add(createIcon(BTN_NO_COLOR, HAS_RIPPLE, "mood"));
		buttonsPanel.add(createIcon(PRIMARY, HAS_RIPPLE, "mood"));
		buttonsPanel.add(createIcon(ACCENT, HAS_RIPPLE, "mood"));

		buttonsPanel.add(createMiniFab(FAB_NO_COLOR, HAS_RIPPLE, "add"));
		buttonsPanel.add(createMiniFab(COLORED, HAS_RIPPLE, "add"));
	}
}