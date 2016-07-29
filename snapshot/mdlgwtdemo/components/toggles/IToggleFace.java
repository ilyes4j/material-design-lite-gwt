package com.github.ilyes4j.gwt.mdl.components.toggles;

/**
 * Interface implemented by classes that provide methods for switching between
 * material faces for toggles.Components involved in the the switching between
 * toggle faces must implement this interface.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @param <T>
 */
public interface IToggleFace<T extends Enum<T>> {

  /**
   * @param flavor
   *          the toggle face to be applied.
   */
  void setFace(T flavor);

  /**
   * 
   * @return the toggle face applied on the component.
   */
  T getFace();
}
