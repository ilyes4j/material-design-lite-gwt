package com.github.ilyes4j.gwt.mdl.demo.navigation.components;

import com.github.ilyes4j.gwt.mdl.demo.navigation.NavigationBar;

/**
 * {@link SideNavigationBar} is a navigation bar that enables the user to switch
 * between components.<br>
 * <br>
 * It can hold a set of {@link ComponentsItem} links that are expressed related
 * to the same common root. When the bar is attached, all the links are
 * rewritten to be expressed related to each other thanks to
 * {@link NavigationBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class SideNavigationBar extends NavigationBar<ComponentsItem> {

  /**
   * Setup the components navigation bar and apply styling.
   */
  public SideNavigationBar() {
    super();

    // setup the bar looks
    getContainer().setStyleName("demo-compsbar");
    getContainer().addStyleName("mdl-shadow--8dp");
  }
}
