package com.github.ilyes4j.gwt.mdl.demo.modules.flips;

import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.menus.ItemClickEvent;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu.ItemClickListener;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.extensions.flips.Flip;
import com.github.ilyes4j.gwt.mdl.extensions.flips.FlipStyle;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for setting the color of the flip. */
public class ColorDemo implements EntryPoint {

  /** Apply a button face to the toggle. */
  public final void onModuleLoad() {

    RootPanel flipCtnr = RootPanel.get("colorContainer");

    FlexTable table = new FlexTable();
    flipCtnr.add(table);

    final InlineLabel uncheckedLbl = new InlineLabel();
    uncheckedLbl.setText("Unchecked color");
    table.setWidget(0, 0, uncheckedLbl);

    final Dropdown unchecked = buildColor();
    table.setWidget(0, 1, unchecked);
    table.getCellFormatter().addStyleName(0, 1, Demo.DEMO.css().padV5());

    final InlineLabel checkedLbl = new InlineLabel();
    checkedLbl.setText("Checked color");
    table.setWidget(1, 0, checkedLbl);

    final Dropdown checked = buildColor();
    table.setWidget(1, 1, checked);
    table.getCellFormatter().addStyleName(1, 1, Demo.DEMO.css().padV5());

    final InlineLabel target = new InlineLabel();
    target.setText("target");
    table.setWidget(2, 0, target);

    final Flip box = new Flip();
    box.setFace(FlipStyle.RAISED);
    box.setRipple(Ripple.HAS_RIPPLE);
    box.setCheckedColor(ButtonColor.PRIMARY);
    box.setValue(true);
    table.setWidget(2, 1, box);
    table.getCellFormatter().addStyleName(2, 1, Demo.DEMO.css().padV5());

    setLabel(box);
    unchecked.setSelected(colorToItem(box.getUncheckedColor()));
    checked.setSelected(colorToItem(box.getCheckedColor()));

    unchecked.addItemClickListener(new ItemClickListener() {
      @Override
      public void onItemClicked(final ItemClickEvent event) {
        box.setUncheckedColor(itemToColor(event.getIndex()));
      }
    });

    checked.addItemClickListener(new ItemClickListener() {
      @Override
      public void onItemClicked(final ItemClickEvent event) {
        box.setCheckedColor(itemToColor(event.getIndex()));
      }
    });

    box.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        setLabel(box);
      }
    });
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
    case 1:
      return ButtonColor.PRIMARY;
    case 2:
      return ButtonColor.ACCENT;
    default:
      return ButtonColor.BTN_NO_COLOR;
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
    case PRIMARY:
      return 1;
    case ACCENT:
      return 2;
    default:
      return 0;
    }
  }

  /**
   * Insures the label is in sync with the state of the flip.
   * 
   * @param box
   *          the box to be synchronized
   */
  private static void setLabel(final Flip box) {
    box.setText(box.getValue() ? "checked" : "unchecked");
  }
}
