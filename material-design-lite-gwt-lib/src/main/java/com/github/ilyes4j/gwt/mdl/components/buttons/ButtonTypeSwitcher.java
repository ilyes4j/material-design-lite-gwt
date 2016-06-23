package com.github.ilyes4j.gwt.mdl.components.buttons;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for button based components.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ButtonTypeSwitcher extends CssSwitcher<ButtonType> {

  @Override
  public Map<ButtonType, String> getMappings() {
    if (map == null) {
      map = new HashMap<ButtonType, String>();

      map.put(ButtonType.FLAT, FLAT_STR);
      map.put(ButtonType.RAISED, RAISED_STR);
      map.put(ButtonType.FAB, FAB_STR);
      map.put(ButtonType.MINIFAB, MINIFAB_STR);
      map.put(ButtonType.ICON, ICON_STR);
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<ButtonType, String> map;

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

  /**
   * Icon CSS class.
   */
  private static final String ICON_STR = FLAT_STR + " mdl-button--icon";
}
