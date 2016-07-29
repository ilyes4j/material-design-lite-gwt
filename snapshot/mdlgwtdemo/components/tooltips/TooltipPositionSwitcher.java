package com.github.ilyes4j.gwt.mdl.components.tooltips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the tooltip anchoring.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class TooltipPositionSwitcher extends CssSwitcher<TooltipPosition> {

  @Override
  public Map<TooltipPosition, String> getMappings() {
    if (map == null) {
      map = new HashMap<TooltipPosition, String>();
      map.put(TooltipPosition.BOTTOM, "mdl-tooltip--bottom");
      map.put(TooltipPosition.TOP, "mdl-tooltip--top");
      map.put(TooltipPosition.LEFT, "mdl-tooltip--left");
      map.put(TooltipPosition.RIGHT, "mdl-tooltip--right");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<TooltipPosition, String> map;
}
