package com.github.ilyes4j.gwt.mdl.demo.modules.sliders;

import com.github.ilyes4j.gwt.mdl.components.sliders.InputEvent;
import com.github.ilyes4j.gwt.mdl.components.sliders.InputHandler;
import com.github.ilyes4j.gwt.mdl.components.sliders.Slider;
import com.github.ilyes4j.gwt.mdl.components.tooltips.Tooltip;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.RootPanel;

/** Demo for a slider with a tooltip. */
public class SliderTooltipDemo implements EntryPoint {

  /** Setup a slider with a tooltip. */
  public final void onModuleLoad() {

    final Slider slider = new Slider();

    final Tooltip tip = new Tooltip(slider, "");
    tip.setText(toPercent(slider, 2));

    slider.addInputHandler(new InputHandler() {

      @Override
      public void onInput(final InputEvent event) {
        tip.setText(toPercent(slider, 2));
      }
    });

    RootPanel.get("tooltipDemo").add(slider);
  }

  /**
   * @param slider
   *          the target slider
   * 
   * @param precision
   *          the percent precision
   * 
   * @return the formatted percent
   */
  private static String toPercent(final Slider slider, final int precision) {

    final double percentMax = 100;
    double value = slider.getValue();
    double min = slider.getMin();
    double max = slider.getMax();
    double result = value * percentMax / (max - min);

    NumberFormat fmt = NumberFormat.getDecimalFormat();

    String resStr = fmt.format(result);

    return resStr + "%";
  }
}
