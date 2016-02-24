package org.zerowarning.gwt.mdl.demo.modules.buttons;

import java.util.ArrayList;
import java.util.Collection;

import org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils;

import com.google.gwt.core.client.EntryPoint;

/**
 * {@link EntryPoint} containing the GWT part of the buttons demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class ButtonDemo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		Collection<EntryPoint> demos = new ArrayList<>();
		demos.add(new ColoredFabDemo());
		demos.add(new PlainFabDemo());
		demos.add(new RaisedColoredDemo());
		demos.add(new RaisedButtonDemo());
		demos.add(new FlatButtonDemo());
		demos.add(new FlatColoredDemo());
		demos.add(new IconButtonDemo());
		demos.add(new MiniFabDemo());

		for (EntryPoint entry : demos) {
			entry.onModuleLoad();
		}

		MdlGwtDemoUtils.insertMainbar();
		MdlGwtDemoUtils.insertComponentsNavbar();
	}
}