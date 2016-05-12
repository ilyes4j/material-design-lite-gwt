package com.github.ilyes4j.gwt.mdl.components.menus;

/**
 * Enables {@link Menu} based components to change the source of the dispatched
 * events.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public interface IHasEventSource {

  /**
   * @param inputSource
   *          the object designated as the source of events published by the
   *          menu
   */
  void setEventSource(final Object inputSource);
}
