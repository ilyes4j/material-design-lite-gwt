package com.github.ilyes4j.gwt.mdl.components.ripples;

/**
 * Components with a ripple effect must implement this interface.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface HasRipple {

  /**
   * @param ripple
   *          the ripple option to be applied to the component
   */
  void setRipple(Ripple ripple);

  /**
   * 
   * @return the ripple option applied to the component
   */
  Ripple getRipple();
}
