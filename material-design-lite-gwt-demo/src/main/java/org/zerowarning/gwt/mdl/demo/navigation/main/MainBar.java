package org.zerowarning.gwt.mdl.demo.navigation.main;

import org.zerowarning.gwt.mdl.demo.navigation.NavigationBar;

/**
 * {@link MainBar} is a tab bar that switches between the main sections of the
 * demo site. It embedded in almost every page of the demo site.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MainBar extends NavigationBar<MainbarItem> {

	/**
	 * Setup the bar and the links it holds.
	 */
	public MainBar() {
		super();

		// setup the bar look
		container.setStyleName("demo-mainbar");

		// setup the link to the about section
		MainbarItem aboutItem = new MainbarItem();
		aboutItem.setUrl("about/about.html");
		aboutItem.setText("about");
		addLink(aboutItem);

		// setup the link to the components section
		MainbarItem compsItem = new MainbarItem();
		compsItem.setUrl("components/components.html");
		compsItem.setText("components");
		addLink(compsItem);
	}
}
