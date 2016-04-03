package com.github.ilyes4j.gwt.mdl.components.toggles;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the top level element in a material check box.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MainCheckSwitcher extends CssSwitcher<CheckBoxStyle> {

  @Override
  public Map<CheckBoxStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<CheckBoxStyle, String>();
      map.put(CheckBoxStyle.CHECKBOX, "mdl-checkbox mdl-js-checkbox");
      map.put(CheckBoxStyle.SWITCH, "mdl-switch mdl-js-switch");
      map.put(CheckBoxStyle.ICON, "mdl-icon-toggle  mdl-js-icon-toggle");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<CheckBoxStyle, String> map;
}
