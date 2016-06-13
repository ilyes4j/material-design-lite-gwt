package com.github.ilyes4j.gwt.mdl.extensions.flips;

import com.github.ilyes4j.gwt.mdl.components.toggles.ToggleStyleOperator;

/**
 * A face switcher for material flips with button-like faces.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @see FlipStyleOperator
 */
public class FlipStyleOperator extends ToggleStyleOperator<FlipStyle> {

  /** */
  public FlipStyleOperator() {
    super(new MainFlipSwitcher(), new InputFlipSwitcher(),
        new LabelFlipSwitcher());
  }

  @Override
  protected FlipStyle defaultFlavor() {
    return FlipStyle.FLAT;
  }
}
