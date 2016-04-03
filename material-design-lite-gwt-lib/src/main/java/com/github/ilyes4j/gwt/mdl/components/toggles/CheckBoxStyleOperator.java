package com.github.ilyes4j.gwt.mdl.components.toggles;

/**
 * <p>
 * A face switcher for material check boxes
 * </p>
 * <p>
 * When making a check box, it is possible to set one of the face options
 * provided in CheckBoxStyle. CheckBoxStyleOperator is the Using The check box
 * provide three faces that can be applied.
 * </p>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class CheckBoxStyleOperator extends ToggleStyleOperator<CheckBoxStyle> {

  /**
   * 
   */
  public CheckBoxStyleOperator() {
    super(new MainCheckSwitcher(), new InputCheckSwitcher(),
        new LabelCheckSwitcher());
  }

  @Override
  protected CheckBoxStyle defaultFlavor() {
    return CheckBoxStyle.CHECKBOX;
  }
}
