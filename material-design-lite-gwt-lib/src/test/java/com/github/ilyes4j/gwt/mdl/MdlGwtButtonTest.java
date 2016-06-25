package com.github.ilyes4j.gwt.mdl;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor;
import com.github.ilyes4j.gwt.mdl.components.buttons.ButtonType;
import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;

/**
 * Tests for the {@link Button} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtButtonTest extends MdlGwtBaseTest {

  /**
   * Call all available methods in {@link Button} in order to track interface
   * evolutions.
   */
  public final void testBreakingChange() {

    // checking builders
    Button.createFab(ACCENT, HAS_RIPPLE, "add");
    Button.createFlat(ACCENT, HAS_RIPPLE, "button");
    Button.createIcon(ACCENT, HAS_RIPPLE, "add");
    Button.createMiniFab(ACCENT, HAS_RIPPLE, "add");
    Button.createRaised(ACCENT, HAS_RIPPLE, "button");

    // checking access
    Button btn = new Button();
    btn.getType();
    btn.getColor();
    btn.getRipple();

    // checking btn colors
    ButtonColor color;
    color = ButtonColor.BTN_NO_COLOR;
    color = ButtonColor.PRIMARY;
    color = ButtonColor.ACCENT;
    btn.setColor(color);

    btn.setIcon("add");

    // checking button type
    ButtonType type;
    type = ButtonType.FAB;
    type = ButtonType.FLAT;
    type = ButtonType.ICON;
    type = ButtonType.MINIFAB;
    type = ButtonType.RAISED;
    btn.setType(type);

    // checking ripples
    Ripple ripple;
    ripple = Ripple.HAS_RIPPLE;
    ripple = Ripple.NONE;
    btn.setRipple(ripple);

    btn.upgrade();

    assertTrue(true);
  }
}
