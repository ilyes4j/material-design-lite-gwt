package com.github.ilyes4j.gwt.mdl.components.toggles;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the input element inside the material toggle.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class InputCheckSwitcher extends CssSwitcher<CheckBoxStyle> {

  @Override
  public Map<CheckBoxStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<CheckBoxStyle, String>();
      map.put(CheckBoxStyle.CHECKBOX, "mdl-checkbox__input");
      map.put(CheckBoxStyle.SWITCH, "mdl-switch__input");
      map.put(CheckBoxStyle.ICON, "mdl-icon-toggle__input");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<CheckBoxStyle, String> map;
}
