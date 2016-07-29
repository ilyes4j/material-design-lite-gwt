package com.github.ilyes4j.gwt.mdl.demo.modules.menus;

import java.util.ArrayList;
import java.util.Collection;

import com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils;
import com.google.gwt.core.client.EntryPoint;

/**
 * {@link EntryPoint} containing the GWT part of the menus demo.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class MenuDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public final void onModuleLoad() {

    Collection<EntryPoint> demos = new ArrayList<>();
    demos.add(new AnchorDemo());
    demos.add(new ClickEventMenuDemo());
    demos.add(new ScrollDemo());
    demos.add(new ToggleEnabledDemo());
    demos.add(new ItemsMenuDemo());
    demos.add(new ClearMenuDemo());
    demos.add(new EnableMenuDemo());

    for (EntryPoint entry : demos) {
      entry.onModuleLoad();
    }

    MdlGwtDemoUtils.insertMainbar();
    MdlGwtDemoUtils.insertComponentsNavbar();
  }
}
