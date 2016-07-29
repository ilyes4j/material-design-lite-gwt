package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.InlineLabel;

/** Common services to help dealing with flip demos. */
public final class FlipHelper {

  /** Private constructor for helper class. */
  private FlipHelper() {
  }

  /**
   * 
   * @param type
   *          the type of the flip
   * 
   * @param ctnr
   *          the container in which the flip is inserted
   * 
   * @return the flip to be created
   */
  public static Flip buildFlip(final ButtonType type, final HasWidgets ctnr) {
    Flip flip = new Flip("checked");
    flip.setFace(type);
    flip.setRipple(Ripple.HAS_RIPPLE);
    flip.addStyleName(Demo.DEMO.css().inline());
    ctnr.add(flip);
    return flip;
  }

  /**
   * Build all the types of the flip component.
   * 
   * @param ctnr
   *          the container in which the flip is inserted
   * 
   * @return the flip to be created
   */
  public static List<Flip> buildFlips(final HasWidgets ctnr) {

    List<Flip> flips = new ArrayList<>();

    for (ButtonType type : EnumSet.allOf(ButtonType.class)) {
      flips.add(FlipHelper.buildFlip(type, ctnr));
    }

    return flips;
  }

  /**
   * @param table
   *          the table to put the flips in
   * 
   * @return the flips
   */
  public static List<Flip> buildFlipsRow(final FlexTable table) {

    int index = table.getRowCount();

    final InlineLabel target = new InlineLabel();
    target.setText("target");
    table.setWidget(index, 0, target);

    FlowPanel panel = new FlowPanel();
    table.setWidget(index, 1, panel);
    table.getCellFormatter().addStyleName(2, 1, Demo.DEMO.css().padV5());

    return FlipHelper.buildFlips(panel);
  }

  /**
   * Set the unchecked state color for all the flips.
   * 
   * @param flips
   *          the target
   * 
   * @param color
   *          the color to be set
   */
  public static void setUncheckedColor(final Collection<Flip> flips,
      final ButtonColor color) {
    for (Flip flip : flips) {
      flip.setUncheckedColor(color);
    }
  }

  /**
   * Set the checked state color for all the flips.
   * 
   * @param flips
   *          the target
   * 
   * @param color
   *          the color to be set
   */
  public static void setCheckedColor(final Collection<Flip> flips,
      final ButtonColor color) {
    for (Flip flip : flips) {
      flip.setCheckedColor(color);
    }
  }
}
