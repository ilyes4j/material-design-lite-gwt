package com.github.ilyes4j.gwt.mdl.components.tooltips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the tooltip style.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class TooltipStyleSwitcher extends CssSwitcher<TooltipStyle> {

  @Override
  public Map<TooltipStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<TooltipStyle, String>();
      map.put(TooltipStyle.DEFAULT, "");
      map.put(TooltipStyle.LARGE, "mdl-tooltip--large");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<TooltipStyle, String> map;
}
