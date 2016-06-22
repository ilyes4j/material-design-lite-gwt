package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.menus.ItemClickEvent;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu.ItemClickListener;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.github.ilyes4j.gwt.mdl.extensions.flips.FlipStyle;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for setting the color of the flip. */
public class ColorDemo implements EntryPoint {

  /** Apply a button face to the toggle. */
  public final void onModuleLoad() {

    ButtonColor unchkclr = ButtonColor.BTN_NO_COLOR;
    ButtonColor chkclr = ButtonColor.PRIMARY;
    boolean val = false;

    RootPanel flipCtnr = RootPanel.get("colorContainer");

    FlexTable table = new FlexTable();
    flipCtnr.add(table);

    Checkbox valueCtrl = buildValueSetter(table, val);

    Dropdown unchecked = buildColorRow("Unchecked color", table);

    Dropdown checked = buildColorRow("Checked color", table);

    final List<Flip> flips = buildFlipsRow(table);

    unchecked.setSelected(colorToItem(unchkclr));
    checked.setSelected(colorToItem(chkclr));

    setValue(flips, val);
    setUncheckedColor(flips, unchkclr);
    setCheckedColor(flips, chkclr);

    unchecked.addItemClickListener(new ItemClickListener() {
      @Override
      public void onItemClicked(final ItemClickEvent event) {
        setUncheckedColor(flips, itemToColor(event.getIndex()));
      }
    });

    checked.addItemClickListener(new ItemClickListener() {
      @Override
      public void onItemClicked(final ItemClickEvent event) {
        setCheckedColor(flips, itemToColor(event.getIndex()));
      }
    });

    valueCtrl.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        setValue(flips, event.getValue());
      }
    });
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
  private static void setUncheckedColor(final Collection<Flip> flips,
      final ButtonColor color) {
    for (Flip flip : flips) {
      flip.setUncheckedColor(color);
    }
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
  private static void setValue(final List<Flip> flips, final boolean value) {

    for (Flip flip : flips) {
      flip.setValue(value);
    }

    final int start = 0;
    final int flip = 2;
    final int last = 5;

    for (int i = start; i < flip; i++) {
      flips.get(i).setText("flip");
    }

    for (int i = flip; i < last; i++) {
      flips.get(i).setText("checked");
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
  private static void setCheckedColor(final Collection<Flip> flips,
      final ButtonColor color) {
    for (Flip flip : flips) {
      flip.setCheckedColor(color);
    }
  }

  /**
   * @param table
   *          the table in which the value setter is attached
   *
   * @param value
   *          the initial checked state
   * 
   * @return the checkbox that controls the value of the flips.
   */
  private static Checkbox buildValueSetter(final FlexTable table,
      final boolean value) {

    int index = table.getRowCount();

    final InlineLabel uncheckedLbl = new InlineLabel();
    uncheckedLbl.setText("Value control");
    table.setWidget(index, 0, uncheckedLbl);

    final Checkbox valueCtrl = new Checkbox();
    valueCtrl.setRipple(Ripple.HAS_RIPPLE);
    valueCtrl.setFace(CheckBoxStyle.SWITCH);
    valueCtrl.setValue(value);
    valueCtrl.addStyleName(Demo.DEMO.css().inline());
    table.setWidget(index, 1, valueCtrl);

    return valueCtrl;
  }

  /**
   * Builds a color chooser for the flip state.
   * 
   * @param lbl
   *          the label of the chooser
   * 
   * @param table
   *          the table to put the chooser in
   * 
   * @return the chooser
   */
  private static Dropdown buildColorRow(final String lbl,
      final FlexTable table) {

    int index = table.getRowCount();

    final InlineLabel uncheckedLbl = new InlineLabel();
    uncheckedLbl.setText("Unchecked color");
    table.setWidget(index, 0, uncheckedLbl);

    final Dropdown unchecked = buildColor();
    table.setWidget(index, 1, unchecked);
    table.getCellFormatter().addStyleName(0, 1, Demo.DEMO.css().padV5());

    return unchecked;
  }

  /**
   * @return a color selector for flip toggles
   */
  private static Dropdown buildColor() {
    Dropdown color = new Dropdown();
    color.setAnchor(MenuAnchor.TOP_LEFT);
    color.addItem("no color", true);
    color.addItem("primary color", true);
    color.addItem("accent color", true);
    color.addStyleName(Demo.DEMO.css().inline());
    return color;
  }

  /**
   * translates choices from the dropdown to button colors enums.
   * 
   * @param index
   *          the drop down choice position
   * 
   * @return the color enumeration
   */
  private static ButtonColor itemToColor(final int index) {

    switch (index) {
    case 0:
      return ButtonColor.BTN_NO_COLOR;
    case 1:
      return ButtonColor.PRIMARY;
    default:
      return ButtonColor.ACCENT;
    }
  }

  /**
   * translates choices back from button colors enums to dropdown items.
   * 
   * @param item
   *          the drop down choice position
   * 
   * @return the color enumeration
   */
  private static int colorToItem(final ButtonColor item) {

    switch (item) {
    case BTN_NO_COLOR:
      return 0;
    case PRIMARY:
      return 1;
    default:
      return 2;
    }
  }

  /**
   * @param table
   *          the table to put the flips in
   * 
   * @return the flips
   */
  private static List<Flip> buildFlipsRow(final FlexTable table) {

    int index = table.getRowCount();

    final InlineLabel target = new InlineLabel();
    target.setText("target");
    table.setWidget(index, 0, target);

    FlowPanel panel = new FlowPanel();
    table.setWidget(index, 1, panel);
    table.getCellFormatter().addStyleName(2, 1, Demo.DEMO.css().padV5());

    return buildFlips(panel);
  }

  /**
   * Build all the types of the flip component.
   * 
   * @param ctnr
   *          the container in which the flip is inserted
   * 
   * @return the flip to be created
   */
  private static List<Flip> buildFlips(final HasWidgets ctnr) {

    List<Flip> flips = new ArrayList<>();

    for (FlipStyle type : EnumSet.allOf(FlipStyle.class)) {
      flips.add(buildFlip(type, ctnr));
    }

    return flips;
  }

  /**
   * 
   * @param style
   *          the type of the flip
   * 
   * @param ctnr
   *          the container in which the flip is inserted
   * 
   * @return the flip to be created
   */
  private static Flip buildFlip(final FlipStyle style, final HasWidgets ctnr) {
    Flip flip = new Flip("checked");
    flip.setFace(style);
    flip.setRipple(Ripple.HAS_RIPPLE);
    flip.addStyleName(Demo.DEMO.css().inline());
    ctnr.add(flip);
    return flip;
  }
}
