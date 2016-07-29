package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import static com.google.gwt.dom.client.Style.Display.INLINE_BLOCK;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.menus.ItemClickEvent;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/** Demonstrates the click event of the IMenu components family. */
public final class ClickEventHelper {

  /** Utility class private constructor. */
  private ClickEventHelper() {
  }

  /**
   * Setup a listener for click events on the menu and change a label to the
   * text of the clicked item.
   * 
   * @param iMenu
   *          the subject of the demonstration
   */
  public static void buildDemo(final IMenu iMenu) {

    RootPanel eventPanel = get("eventContainer");

    // setup a label next to the menu to react to click events from the menu
    final Label lbl = new Label();
    // add some css styling to the label
    lbl.addStyleName("demo-text");
    lbl.addStyleName(Demo.DEMO.css().inline());

    final String item = "I choose Option #";

    // set the inline-block
    iMenu.asWidget().getElement().getStyle().setDisplay(INLINE_BLOCK);

    // add items to the menu
    iMenu.addItem(item + "1", true);
    // it is possible to add disabled menu that won't respond to click events
    iMenu.addItem(item + "2", false);
    iMenu.addItem(item + "3", true);

    // attach the menu to the DOM
    eventPanel.add(iMenu);

    // setup a listener for the menu
    iMenu.addItemClickListener(new Menu.ItemClickListener() {

      @Override
      public void onItemClicked(final ItemClickEvent event) {
        // the source of the event is a reference on the menu
        if (event.getSource() == iMenu) {
          // change the text of the label when an enabled item is clicked
          lbl.setText(event.getValue());
        }
      }
    });

    // attach the label to the DOM
    eventPanel.add(lbl);
  }
}
