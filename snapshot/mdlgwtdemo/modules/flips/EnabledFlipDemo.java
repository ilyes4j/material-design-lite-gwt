package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import java.util.List;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for enabling/disabling flips. */
public class EnabledFlipDemo implements EntryPoint {

  /** When the switch is pushed enable/disable the flips. */
  public final void onModuleLoad() {

    ButtonColor unchkclr = ButtonColor.BTN_NO_COLOR;
    ButtonColor chkclr = ButtonColor.PRIMARY;
    boolean enabled = false;

    RootPanel flipCtnr = RootPanel.get("enabledContainer");

    FlexTable table = new FlexTable();
    flipCtnr.add(table);

    Checkbox enabledCtrl = buildPropControl(table, enabled, "Enabled");

    final List<Flip> flips = FlipHelper.buildFlipsRow(table);

    setEnabled(flips, enabled);
    FlipHelper.setUncheckedColor(flips, unchkclr);
    FlipHelper.setCheckedColor(flips, chkclr);

    enabledCtrl.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        setEnabled(flips, event.getValue());
      }
    });
  }

  /**
   * Set the checked state for all the flips.
   * 
   * @param flips
   *          the target
   * 
   * @param value
   *          the value to be set for the flips
   */
  private static void setEnabled(final List<Flip> flips, final boolean value) {

    for (Flip flip : flips) {
      flip.setEnabled(value);
    }
  }

  /**
   * @param table
   *          the table in which the property controller is attached
   *
   * @param value
   *          the initial property state
   * 
   * @param label
   *          the label of the property
   * 
   * @return the checkbox that controls the property
   */
  private static Checkbox buildPropControl(final FlexTable table,
      final boolean value, final String label) {

    int index = table.getRowCount();

    final InlineLabel disabledLbl = new InlineLabel();
    disabledLbl.setText(label);
    table.setWidget(index, 0, disabledLbl);

    final Checkbox valueCtrl = new Checkbox();
    valueCtrl.setRipple(Ripple.HAS_RIPPLE);
    valueCtrl.setFace(CheckBoxStyle.SWITCH);
    valueCtrl.setValue(value);
    valueCtrl.addStyleName(Demo.DEMO.css().inline());
    table.setWidget(index, 1, valueCtrl);

    return valueCtrl;
  }
}
