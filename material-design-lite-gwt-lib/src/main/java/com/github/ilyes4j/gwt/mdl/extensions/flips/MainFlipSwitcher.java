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

      map.put(FlipStyle.RAISED, PLAIN_STR);
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
   * Common CSS classes for flips.
   */
  private static final String BASE_STR = "mdl-js-button mdl-button ";

  /**
   * Plain CSS styles.
   */
  private static final String PLAIN_STR = BASE_STR + "mdl-button--raised";

  /**
   * Fab CSS styles.
   */
  private static final String FAB_STR = BASE_STR + "mdl-button--fab";

  /**
   * Mini Fab CSS styles.
   */
  private static final String MINIFAB_STR = FAB_STR + " mdl-button--mini-fab";
}
