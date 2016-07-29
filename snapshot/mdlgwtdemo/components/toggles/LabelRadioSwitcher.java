package com.github.ilyes4j.gwt.mdl.components.toggles;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for the label element inside the material radio button.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class LabelRadioSwitcher extends CssSwitcher<RadioStyle> {

  @Override
  public Map<RadioStyle, String> getMappings() {
    if (map == null) {
      map = new HashMap<RadioStyle, String>();
      map.put(RadioStyle.RADIO, "mdl-radio__label");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<RadioStyle, String> map;
}
