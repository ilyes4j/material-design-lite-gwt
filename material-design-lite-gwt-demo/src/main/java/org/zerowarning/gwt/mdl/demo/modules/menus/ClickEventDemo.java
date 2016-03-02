package org.zerowarning.gwt.mdl.demo.modules.menus;

import static com.google.gwt.dom.client.Style.Display.INLINE_BLOCK;
import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.ItemClickEvent;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.components.menus.MenuCombo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Demonstrates the click event of the menu component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ClickEventDemo implements EntryPoint {

  /**
   * Setup a listener for click events on the menu and change a label to the
   * text of the clicked item.
   */
  @Override
  public void onModuleLoad() {

    final String BTN_TEXT = "Choose option";
    final String ITEM_VALUE = "I choose Option #";

    RootPanel eventPanel = get("eventContainer");

    // setup a label next to the menu to react to click events from the menu
    final Label lbl = new Label();
    // set an initial text for the button
    lbl.setText(BTN_TEXT);
    // add some css styling to the label
    lbl.addStyleName("demo-text");
    lbl.addStyleName("demo-menu-event-label");
    // attach the label to the DOM

    
    // setup the action button.
    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);

    // setup a menu
    MenuCombo menu = new MenuCombo(btn);

    // set the inline-block
    menu.getElement().getStyle().setDisplay(INLINE_BLOCK);

    // add items to the menu
    menu.addItem(ITEM_VALUE + "1", true);
    // it is possible to add disabled menu that won't respond to click events
    menu.addItem(ITEM_VALUE + "2", false);
    menu.addItem(ITEM_VALUE + "3", true);
    // attach the menu to the DOM
    eventPanel.add(menu);

    // setup a listener for the menu
    menu.addItemClickListener(new Menu.ItemClickListener() {

      @Override
      public void onItemClicked(ItemClickEvent event) {
        // change the text of the label when an enabled item is clicked
        lbl.setText(event.getValue());
      }
    });
    
    eventPanel.add(lbl);
  }
}
