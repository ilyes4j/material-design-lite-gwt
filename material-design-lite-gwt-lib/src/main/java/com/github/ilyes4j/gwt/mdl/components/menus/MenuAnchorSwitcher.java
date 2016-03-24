package com.github.ilyes4j.gwt.mdl.components.menus;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * CSS class switcher for {@link MenuAnchor}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MenuAnchorSwitcher extends CssSwitcher<MenuAnchor> {

  @Override
  public final Map<MenuAnchor, String> getMappings() {

    if (map == null) {
      map = new HashMap<MenuAnchor, String>();
      map.put(MenuAnchor.BOTTOM_LEFT, "");
      map.put(MenuAnchor.BOTTOM_RIGHT, "mdl-menu--bottom-right");
      map.put(MenuAnchor.TOP_LEFT, "mdl-menu--top-left");
      map.put(MenuAnchor.TOP_RIGHT, "mdl-menu--top-right");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<MenuAnchor, String> map;
}
