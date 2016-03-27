package com.github.ilyes4j.gwt.mdl.components.ripples;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyes4j.gwt.mdl.components.CssSwitcher;

/**
 * CSS class switcher for the {@link Ripple} enumeration.
 * 
 * @see CssSwitcher
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class RippleSwitcher extends CssSwitcher<Ripple> {

  @Override
  public final Map<Ripple, String> getMappings() {

    if (map == null) {
      map = new HashMap<Ripple, String>();
      map.put(Ripple.NONE, "");
      map.put(Ripple.HAS_RIPPLE, "mdl-js-ripple-effect");
    }

    return map;
  }

  /**
   * Stores the link between an enumeration constant and its CSS class name.
   */
  private static Map<Ripple, String> map;
}
