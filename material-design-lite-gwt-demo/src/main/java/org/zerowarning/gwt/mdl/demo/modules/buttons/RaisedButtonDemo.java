package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import org.zerowarning.gwt.mdl.components.buttons.Button;

import com.google.gwt.core.client.EntryPoint;

/**
 * Raised buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class RaisedButtonDemo implements EntryPoint {

	public void onModuleLoad() {

		final String TXT = "Button";

		// create a plain raised button
		get("ctnr_06").add(createRaised(BTN_NO_COLOR, NONE, TXT));

		// create a plain raised button with ripple
		get("ctnr_07").add(createRaised(BTN_NO_COLOR, HAS_RIPPLE, TXT));

		// create a plain raised disabled button
		Button btnRaised = createRaised(BTN_NO_COLOR, NONE, TXT);
		btnRaised.setEnabled(false);
		get("ctnr_08").add(btnRaised);
	}
}