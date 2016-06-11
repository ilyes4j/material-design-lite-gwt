package com.github.ilyes4j.gwt.mdl.extensions.flips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the label element inside the material flip.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class LabelFlipSwitcher extends CssSwitcher<FlipStyle> {

  @Override
  public Map<FlipStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<FlipStyle, String>();

      map.put(FlipStyle.RAISED, "mdl-button-toggle__label");
      map.put(FlipStyle.FAB, "mdl-button-toggle__label material-icons");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<FlipStyle, String> map;
}
