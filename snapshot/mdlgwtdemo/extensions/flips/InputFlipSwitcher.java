package com.github.ilyes4j.gwt.mdl.extensions.flips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;

/**
 * A {@link CssSwitcher} for the input element inside the material flip
 * component.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class InputFlipSwitcher extends CssSwitcher<ButtonType> {

  @Override
  public Map<ButtonType, String> getMappings() {
    if (map == null) {
      map = new HashMap<ButtonType, String>();

      map.put(ButtonType.FLAT, "mdl-icon-toggle__input");
      map.put(ButtonType.RAISED, "mdl-icon-toggle__input");
      map.put(ButtonType.FAB, "mdl-icon-toggle__input");
      map.put(ButtonType.MINIFAB, "mdl-icon-toggle__input");
      map.put(ButtonType.ICON, "mdl-icon-toggle__input");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<ButtonType, String> map;
}
