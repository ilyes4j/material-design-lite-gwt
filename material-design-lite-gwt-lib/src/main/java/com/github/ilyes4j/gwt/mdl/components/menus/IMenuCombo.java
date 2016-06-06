package com.github.ilyes4j.gwt.mdl.components.menus;

/**
 * A menu combo is a menu that supports enabling and disabling.
 * 
 * @author Moahmed Ilyes DIMASSI
 */
public interface IMenuCombo extends IMenu, IHasEventSource {

  /**
   * @param enable
   *          if <code>true</code> then the action button of the menu is set to
   *          be enabled, <code>false</code> then the action button is disabled
   */
  void setEnabled(final boolean enable);

  /**
   * @return <code>true</code> if the menu's action button is enabled,
   *         <code>false</code> if it is disabled.
   */
  boolean isEnabled();
}
