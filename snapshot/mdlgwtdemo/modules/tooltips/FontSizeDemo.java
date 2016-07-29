package com.github.ilyes4j.gwt.mdl.demo.modules.tooltips;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipPosition.BOTTOM;
import static com.github.ilyes4j.gwt.mdl.components.tooltips.TooltipStyle.LARGE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.tooltips.Tooltip;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/** Font size demo. */
public class FontSizeDemo implements EntryPoint {

  /** When the page loads attach the tooltip to its target. */
  public final void onModuleLoad() {

    String style = Demo.DEMO.css().margin();

    // setup an icon button
    Button add = Button.createIcon(BTN_NO_COLOR, HAS_RIPPLE, "add");
    // add some horizontal spacing to it
    add.addStyleName(style);
    // attach a tooltip to the icon. The tooltip shows up by default at the
    // bottom of its target with a regular font size
    new Tooltip(add, "This tooltip is small");

    Button print = Button.createIcon(BTN_NO_COLOR, HAS_RIPPLE, "print");
    print.addStyleName(style);
    // setup the tooltip to be large sized and showing up below its target
    new Tooltip(print, "This tooltip is large", BOTTOM, LARGE);

    RootPanel root = RootPanel.get("fontsizeContainer");
    root.add(add);
    root.add(print);
  }
}
