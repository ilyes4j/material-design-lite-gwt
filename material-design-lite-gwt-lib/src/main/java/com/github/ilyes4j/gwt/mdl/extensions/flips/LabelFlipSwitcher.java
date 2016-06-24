package com.github.ilyes4j.gwt.mdl.extensions.flips;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;

/**
 * A {@link CssSwitcher} for the label element inside the material flip.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class LabelFlipSwitcher extends CssSwitcher<ButtonType> {

  @Override
  public Map<ButtonType, String> getMappings() {
    if (map == null) {
      map = new HashMap<ButtonType, String>();

      map.put(ButtonType.FLAT, "mdl-button-toggle__label");
      map.put(ButtonType.RAISED, "mdl-button-toggle__label");
      map.put(ButtonType.FAB, "mdl-button-toggle__label material-icons");
      map.put(ButtonType.MINIFAB, "mdl-button-toggle__label material-icons");
      map.put(ButtonType.ICON, "mdl-button-toggle__label material-icons");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<ButtonType, String> map;
}
