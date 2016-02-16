package org.zerowarning.gwt.mdl.demo;

import org.zerowarning.gwt.mdl.demo.utils.DemoUtils;

import com.google.gwt.core.client.EntryPoint;

/**
 * GWT module for the about demo page.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class AboutDemo implements EntryPoint {

	@Override
	public void onModuleLoad() {

		// put the main navigation bar in the header for the demo page.
		DemoUtils.insertMainbar();
	}
}