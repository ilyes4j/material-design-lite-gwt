package org.zerowarning.gwt.mdl.demo.utils;

import static com.google.gwt.user.client.ui.RootPanel.get;

import org.zerowarning.gwt.mdl.demo.navigation.components.ComponentsItem;
import org.zerowarning.gwt.mdl.demo.navigation.components.SideNavigationBar;
import org.zerowarning.gwt.mdl.demo.navigation.main.MainBar;
import org.zerowarning.gwt.mdl.demo.navigation.main.MainbarItem;

/**
 * Reusable code for the demos.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class DemoUtils {

	/**
	 * Stores the id of the main section of the demo page. This is the id of the
	 * DOM element under which the side bar is sitting.
	 */
	public static final String MAIN = "demo-main";

	/**
	 * Stores the id of the header under which the main navigation bar is
	 * sitting.
	 */
	public static final String HEADER = "header-link-row";

	/**
	 * Setup the components side bar and inject it inside the main section of a
	 * demo page.
	 */
	public static void insertComponentsNavbar() {

		SideNavigationBar bar = new SideNavigationBar();

		// setup the button link.
		ComponentsItem button = new ComponentsItem("keyboard_arrow_right");
		// the text of the link
		button.setCaption("Buttons");
		// the url of the link relative to "components" node
		button.setUrl("components/buttons/buttons.html");
		// add the link to the navigation bar
		bar.addLink(button);

		// setup the menu link
		ComponentsItem menu = new ComponentsItem("menu");
		menu.setCaption("Menus");
		menu.setUrl("components/menus/menus.html");
		bar.addLink(menu);

		// insert the side bar under the main section of the demo page
		get(MAIN).insert(bar, 0);
	}

	/**
	 * Setup the main bar of the demo and inject it inside the header
	 */
	public static void insertMainbar() {

		// setup the main bar
		MainBar mainbar = new MainBar();

		// setup the link to the about section
		MainbarItem aboutItem = new MainbarItem();
		aboutItem.setUrl("about/about.html");
		aboutItem.setText("about");
		mainbar.addLink(aboutItem);

		// setup the link to the components section
		MainbarItem compsItem = new MainbarItem();
		compsItem.setUrl("components/components.html");
		compsItem.setText("components");
		mainbar.addLink(compsItem);

		// insert the main bar under the header section of the demo page
		get(HEADER).insert(mainbar, 0);
	}
}
