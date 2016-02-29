package org.zerowarning.gwt.mdl.demo.modules.menus;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import java.util.ArrayList;
import java.util.Collection;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.ItemClickEvent;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * {@link EntryPoint} containing the GWT part of the menus demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class MenuDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    Collection<EntryPoint> demos = new ArrayList<>();
    demos.add(new AnchorDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    eventClickDemo();
    menusScrollDemo();

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertComponentsNavbar();
  }

  private void eventClickDemo() {

    final String EVENT_CONTAINER = "eventContainer";
    final String COMBO_ID = "menu_event_sample";
    final String BTN_TEXT = "Choose option";
    final String ITEM_VALUE = "I choose Option #";

    RootPanel eventPanel = get(EVENT_CONTAINER);

    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);
    btn.getElement().setId(COMBO_ID);
    eventPanel.add(btn);

    Menu menu = new Menu();
    menu.setActionId(COMBO_ID);
    menu.addItem(ITEM_VALUE + "1", true);
    menu.addItem(ITEM_VALUE + "2", false);
    menu.addItem(ITEM_VALUE + "3", true);
    eventPanel.add(menu);

    final Label lbl = new Label();
    lbl.setText("Choose option");
    lbl.addStyleName("demo-text");
    lbl.addStyleName("demo-menu-event-label");
    eventPanel.add(lbl);

    menu.addItemClickListener(new Menu.ItemClickListener() {

      @Override
      public void onItemClicked(ItemClickEvent event) {
        lbl.setText(event.getValue());
      }
    });
  }

  private void menusScrollDemo() {
    final String SCROLL_CONTAINER = "scrollContainer";
    final String BTN_TEXT = "I need a scroll";
    final String COMBO_ID = "menu_scroll_sample";
    final String ITEM_VALUE = "Menu Option #";

    RootPanel eventPanel = RootPanel.get(SCROLL_CONTAINER);

    Button btn = createRaised(BTN_NO_COLOR, HAS_RIPPLE, BTN_TEXT);
    btn.getElement().setId(COMBO_ID);
    eventPanel.add(btn);

    Menu menu = new Menu();
    menu.setAnchor(TOP_LEFT);
    menu.setActionId(COMBO_ID);
    for (int i = 0; i < 20; i++) {
      menu.addItem(ITEM_VALUE + i, true);
    }
    eventPanel.add(menu);
  }
}
