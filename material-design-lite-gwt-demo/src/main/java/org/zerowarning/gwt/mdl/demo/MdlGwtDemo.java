package org.zerowarning.gwt.mdl.demo;

import static org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils.ABOUT;
import static org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils.BUTTONS;
import static org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils.MENUS;

import java.util.ArrayList;
import java.util.List;

import org.zerowarning.gwt.mdl.demo.modules.AboutDemo;
import org.zerowarning.gwt.mdl.demo.modules.ButtonDemo;
import org.zerowarning.gwt.mdl.demo.modules.MenuDemo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * {@link MdlGwtDemo} is an {@link EntryPoint} congregation. Its purpose is to
 * map the appropriate {@link EntryPoint} to its target html page and therefore
 * avoid having to write a separate GWT module for each demo page.<br>
 * <br>
 * <code>org.zerowarning.gwt.mdl.demo.MdlGwtDemo</code> represents the GWT part
 * of the demo. Using the GWT compiler, this module is compiled to a set of
 * javascript and css files placed under <code>mdlgwtdemo/</code>.<br>
 * <br>
 * To use this module in a demo page,
 * <code>mdlgwtdemo/mdlgwtdemo.nocache.js</code> has to be included in the head
 * section of the page.<br>
 * <br>
 * MdlGwtDemo is the entry point of
 * <code>org.zerowarning.gwt.mdl.demo.MdlGwtDemo</code>. This means that when
 * the page containing <code>mdlgwtdemo/mdlgwtdemo.nocache.js</code> is loaded,
 * the entry point method {@link MdlGwtDemo#onModuleLoad()} is executed.<br>
 * <br>
 * <code>MdlGwtDemo</code> does include the page demo on its own. Instead, it
 * delegates its processing to the appropriate {@link ModuleDemo} instance. For
 * that matter, <code>MdlGwtDemo</code> stores a collection of
 * <code>ModuleDemo</code> each mapped to a url using
 * {@link ModuleDemo#setUrl(String)} and contains an {@link EntryPoint} using
 * {@link ModuleDemo#setModule(EntryPoint)}. If the <code>ModuleDemo</code> url
 * matches the one of the currently loaded page, then the
 * <code>onModuleLoad()</code> method of its EntryPoint is executed.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class MdlGwtDemo implements EntryPoint {

	/**
	 * Setup the {@link ModuleDemo}s collection and map each one with the
	 * appropriate url and {@link EntryPoint}.
	 */
	public MdlGwtDemo() {
		ModuleDemo about = new ModuleDemo();
		about.setUrl(ABOUT);
		about.setModule(new AboutDemo());
		entries.add(about);

		ModuleDemo buttons = new ModuleDemo();
		buttons.setUrl(BUTTONS);
		buttons.setModule(new ButtonDemo());
		entries.add(buttons);

		ModuleDemo menus = new ModuleDemo();
		menus.setUrl(MENUS);
		menus.setModule(new MenuDemo());
		entries.add(menus);
	}

	/**
	 * Depending on the current url, invoques the appropriate {@link ModuleDemo}
	 * to handle the demo GWT part.
	 */
	@Override
	public void onModuleLoad() {

		String ref = Window.Location.getHref();

		for (ModuleDemo module : entries) {
			if (module.isIncludedIn(ref)) {
				module.onModuleLoad();
				break;
			}
		}
	}

	private List<ModuleDemo> entries = new ArrayList<ModuleDemo>();
}