package org.zerowarning.gwt.mdl.demo;

import static com.google.gwt.user.client.ui.RootPanel.get;

import org.zerowarning.gwt.mdl.demo.navigation.main.MainBar;

import com.google.gwt.core.client.EntryPoint;

/**
 * @author Mohamed Ilyes DIMASSI
 */
public class AboutDemo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		get("header-link-row").insert(new MainBar(), 0);
	}
}