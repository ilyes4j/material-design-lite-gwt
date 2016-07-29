package com.github.ilyes4j.gwt.mdl.components;

/**
 * Normalizing the management of upgrade and downgrade for mdl components.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class UpgradeHelper implements IUpgrade {

  @Override
  public void upgrade() {
    upgraded = true;
  }

  @Override
  public boolean isUpgraded() {
    return upgraded;
  }

  /**
   * Stores the upgraded state of the component.
   */
  private boolean upgraded;
}
