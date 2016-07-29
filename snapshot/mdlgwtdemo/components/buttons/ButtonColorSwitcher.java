package com.github.ilyes4j.gwt.mdl.components.buttons;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * A {@link CssSwitcher} for mdl button colors.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ButtonColorSwitcher extends CssSwitcher<ButtonColor> {

  @Override
  public Map<ButtonColor, String> getMappings() {
    if (map == null) {
      map = new HashMap<ButtonColor, String>();
      map.put(ButtonColor.ACCENT, "mdl-button--accent");
      map.put(ButtonColor.PRIMARY, "mdl-button--primary");
      map.put(ButtonColor.BTN_NO_COLOR, "");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<ButtonColor, String> map;
}
