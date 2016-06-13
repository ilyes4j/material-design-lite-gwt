package com.github.ilyes4j.gwt.mdl.extensions.flips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the input element inside the material flip
 * component.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class InputFlipSwitcher extends CssSwitcher<FlipStyle> {

  @Override
  public Map<FlipStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<FlipStyle, String>();

      map.put(FlipStyle.FLAT, "mdl-icon-toggle__input");
      map.put(FlipStyle.RAISED, "mdl-icon-toggle__input");
      map.put(FlipStyle.FAB, "mdl-icon-toggle__input");
      map.put(FlipStyle.MINIFAB, "mdl-icon-toggle__input");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<FlipStyle, String> map;
}
