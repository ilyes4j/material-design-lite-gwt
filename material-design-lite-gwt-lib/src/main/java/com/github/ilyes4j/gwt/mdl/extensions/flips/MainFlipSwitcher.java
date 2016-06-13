package com.github.ilyes4j.gwt.mdl.extensions.flips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the top level element in a material flip.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MainFlipSwitcher extends CssSwitcher<FlipStyle> {

  @Override
  public Map<FlipStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<FlipStyle, String>();

      map.put(FlipStyle.FLAT, FLAT_STR);
      map.put(FlipStyle.RAISED, RAISED_STR);
      map.put(FlipStyle.FAB, FAB_STR);
      map.put(FlipStyle.MINIFAB, MINIFAB_STR);
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<FlipStyle, String> map;

  /**
   * Flat CSS class.
   */
  private static final String FLAT_STR = "mdl-js-button mdl-button";
  
  /**
   * Plain CSS styles.
   */
  private static final String RAISED_STR = FLAT_STR + " mdl-button--raised";

  /**
   * Fab CSS styles.
   */
  private static final String FAB_STR = FLAT_STR + " mdl-button--fab";

  /**
   * Mini Fab CSS styles.
   */
  private static final String MINIFAB_STR = FAB_STR + " mdl-button--mini-fab";
}
