package com.github.ilyes4j.gwt.mdl.components.textfields;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * CSS class switcher for the {@link Float} enumeration.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class FloatSwitcher extends CssSwitcher<Float> {

  @Override
  public final Map<Float, String> getMappings() {

    if (map == null) {
      map = new HashMap<Float, String>();
      map.put(Float.NO_FLOAT, "");
      map.put(Float.FLOAT, "mdl-textfield--floating-label");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<Float, String> map;
}
