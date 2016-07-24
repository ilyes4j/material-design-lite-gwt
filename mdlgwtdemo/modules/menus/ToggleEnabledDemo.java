package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/** Changing the enabled state of a menu. */
public class ToggleEnabledDemo implements EntryPoint {

  /** Change the state of the item when a button is clicked. */
  public final void onModuleLoad() {

    RootPanel cont = RootPanel.get("toggleContainer");

    // attach the toggle to its parent
    Button toggle = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Toggle");
    cont.add(toggle);

    Button btn = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Menu");

    // Instantiate a menu
    final MenuCombo menu = new MenuCombo(btn);
    menu.addStyleName("demo-menu-event-label");

    // add the items to the menu
    menu.addItem("Some action", true);
    menu.addItem("Another action", true);
    menu.addItem("Yet another action", true);

    // attach the menu to its parent
    cont.add(menu);

    // setup a label next to the menu to react to click events from the toggle
    final Label lbl = new Label();
    // set an initial text for the button
    lbl.setText(FIRST_ITEM_ENABLED);
    // add some css styling to the label
    lbl.addStyleName("demo-text");
    lbl.addStyleName("demo-menu-event-label");
    cont.add(lbl);

    toggle.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(final ClickEvent event) {
        int itemIndex = 0;
        //toggle the enabled state of the item
        boolean enabled = !menu.isEnabled(itemIndex);
        //apply the state to the item
        menu.setEnabled(itemIndex, enabled);
        //change the text according to the applied state
        lbl.setText(enabled ? FIRST_ITEM_ENABLED : FIRST_ITEM_DISABLED);
      }
    });
  }
  
  /** Lable displayed when the first of the menu is enabled. */
  private static final String FIRST_ITEM_ENABLED = "First item is enabled";

  /** Lable displayed when the first of the menu is disabled. */
  private static final String FIRST_ITEM_DISABLED = "First item is disabled";
}
