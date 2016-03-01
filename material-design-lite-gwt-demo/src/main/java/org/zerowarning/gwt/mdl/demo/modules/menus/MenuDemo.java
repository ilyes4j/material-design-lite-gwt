package org.zerowarning.gwt.mdl.demo.modules.menus;

import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static org.zerowarning.gwt.mdl.components.menus.MenuAnchor.TOP_LEFT;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import java.util.ArrayList;
import java.util.Collection;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.demo.utils.MdlGwtDemoUtils;

import com.google.gwt.core.client.EntryPoint;
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
    demos.add(new ClickEventDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    menusScrollDemo();

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertComponentsNavbar();
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
