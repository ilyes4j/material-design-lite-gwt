package com.github.ilyes4j.gwt.mdl.components;

/**
 * An MDL component implements the {@link IUpgrade} interface to
 * indicate that it can be upgraded. The upgrade means applying javascript
 * behaviors and effects on the component. An upgradable component is upgraded
 * when {@link IUpgrade#upgrade()} is invoked.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public interface IUpgrade {

  /**
   * Causes the component to be upgraded.
   */
  void upgrade();

  /**
   * @return the upgrade state of the component
   */
  boolean isUpgraded();
}
