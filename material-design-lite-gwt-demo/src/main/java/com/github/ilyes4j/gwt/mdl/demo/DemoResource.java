package com.github.ilyes4j.gwt.mdl.demo;

import com.github.ilyes4j.gwt.mdl.demo.navigation.components.ComponentsItem;
import com.github.ilyes4j.gwt.mdl.demo.navigation.components.SideNavigationBar;
import com.github.ilyes4j.gwt.mdl.demo.navigation.main.MainBar;
import com.github.ilyes4j.gwt.mdl.demo.navigation.main.MainbarItem;
import com.google.gwt.resources.client.CssResource;

/**
 * A GSS resource bundle containing all the CSS rules for the demo application.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public interface DemoResource extends CssResource {

  /** @return the CSS class for the {@link MainBar} */
  @ClassName("demo-mainbar")
  String mainBar();

  /** @return the CSS class to make a div in-lined and spaced out */
  @ClassName("demo-menu-event-label")
  String inline();

  /**
   * @return the CSS class for a {@link MainbarItem} inside a {@link MainBar}
   */
  @ClassName("demo-mainbar-item")
  String barItem();

  /**
   * @return the CSS class for the icon of an {@link ComponentsItem} in the list
   *         of items inside the {@link SideNavigationBar}
   */
  @ClassName("demo-compsbar-item-icon")
  String compsBarItemIcon();

  /**
   * @return the CSS class for an {@link ComponentsItem} in the list of items
   *         inside the {@link SideNavigationBar}
   */
  @ClassName("demo-compsbar-item")
  String compsBarItem();

  /** @return the CSS class for the {@link SideNavigationBar} */
  @ClassName("demo-compsbar")
  String compsBar();

  /** @return spacing components on the same line */
  @ClassName("component-margin")
  String margin();
}
