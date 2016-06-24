package com.github.ilyes4j.gwt.mdl.extensions.flips;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonTypeSwitcher;
import com.github.ilyes4j.gwt.mdl.components.toggles.ToggleStyleOperator;

/**
 * A face switcher for material flips with button-like faces.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @see FlipStyleOperator
 */
public class FlipStyleOperator extends ToggleStyleOperator<ButtonType> {

  /** */
  public FlipStyleOperator() {
    super(new ButtonTypeSwitcher(), new InputFlipSwitcher(),
        new LabelFlipSwitcher());
  }

  @Override
  protected ButtonType defaultFlavor() {
    return ButtonType.FLAT;
  }
}
