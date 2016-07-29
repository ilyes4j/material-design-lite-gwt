package com.github.ilyes4j.gwt.mdl.components.ripples;

/**
 * Material components with a ripple effect must implement this interface.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface HasRipple {

  /**
   * indicate whether this component should have a ripple.
   * 
   * @param ripple
   *          the ripple option to be applied to the component
   */
  void setRipple(Ripple ripple);

  /**
   * Returns whether this component have a ripple.
   * 
   * @return the ripple option applied to the component
   */
  Ripple getRipple();
}
