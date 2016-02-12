package org.zerowarning.gwt.mdl.demo.navigation.components;

import org.zerowarning.gwt.mdl.demo.navigation.NavigationBar;

/**
 * {@link ComponentsBar} is a navigation bar that enables the user to switch
 * between components demos.<br>
 * <br>
 * It Holds a set of {@link ComponentsItem} links. All links are expressed
 * related to the same common root. When the bar is attached all the links are
 * rewritten to be expressed related to each other thanks to
 * {@link NavigationBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ComponentsBar extends NavigationBar<ComponentsItem> {

	/**
	 * Setup the components navigation bar and all the navigation items it
	 * holds.
	 */
	public ComponentsBar() {
		super();

		// setup the bar looks
		container.setStyleName("demo-compsbar");
		container.addStyleName("mdl-shadow--8dp");

		// setup the button link.
		ComponentsItem button = new ComponentsItem("keyboard_arrow_right");
		// the text of the link
		button.setCaption("Buttons");
		// the url of the link relative to "components" node
		button.setUrl("components/buttons/buttons.html");
		// add the link to the navigation bar
		addLink(button);

		// setup the menu link
		ComponentsItem menu = new ComponentsItem("menu");
		menu.setCaption("Menus");
		menu.setUrl("components/menus/menus.html");
		addLink(menu);
	}
}
