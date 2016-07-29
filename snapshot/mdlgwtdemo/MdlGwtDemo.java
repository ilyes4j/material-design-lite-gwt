package com.github.ilyes4j.gwt.mdl.demo;

import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.ABOUT;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.BUTTONS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.DROPS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.FLIPS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.MENUS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.SLIDERS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.TOGGLES;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.TOOLTIPS;
import static com.github.ilyes4j.gwt.mdl.demo.utils.MdlGwtDemoUtils.TXTFLDS;

import java.util.ArrayList;
import java.util.List;

import com.github.ilyes4j.gwt.mdl.demo.modules.AboutDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.buttons.ButtonDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns.DropdownDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.flips.FlipDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.menus.MenuDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.sliders.SliderDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.textfields.TextfieldDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.toggles.ToggleDemo;
import com.github.ilyes4j.gwt.mdl.demo.modules.tooltips.TooltipDemo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * {@link MdlGwtDemo} is an {@link EntryPoint} congregation. Its purpose is to
 * map the appropriate {@link EntryPoint} to its target html page and therefore
 * avoid having to write a separate GWT module for each demo page.<br>
 * <br>
 * <code>com.github.ilyes4j.gwt.mdl.demo.MdlGwtDemo</code> represents the GWT
 * part of the demo. Using the GWT compiler, this module is compiled to a set of
 * javascript and css files placed under <code>mdlgwtdemo/</code>.<br>
 * <br>
 * To use this module in a demo page,
 * <code>mdlgwtdemo/mdlgwtdemo.nocache.js</code> has to be included in the head
 * section of the page.<br>
 * <br>
 * MdlGwtDemo is the entry point of
 * <code>com.github.ilyes4j.gwt.mdl.demo.MdlGwtDemo</code>. This means that when
 * the page containing <code>mdlgwtdemo/mdlgwtdemo.nocache.js</code> is loaded,
 * the entry point method {@link MdlGwtDemo#onModuleLoad()} is executed.<br>
 * <br>
 * <code>MdlGwtDemo</code> does include the page demo on its own. Instead, it
 * delegates its processing to the appropriate {@link ModuleDemo} instance. For
 * that matter, <code>MdlGwtDemo</code> stores a collection of
 * <code>ModuleDemo</code> each mapped to a url using
 * {@link ModuleDemo#setUrl(String)} and contains an {@link EntryPoint} using
 * {@link ModuleDemo#setModule(EntryPoint)}. If the <code>ModuleDemo</code> url
 * matches the one of the currently loaded page, then the
 * <code>onModuleLoad()</code> method of its EntryPoint is executed.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class MdlGwtDemo implements EntryPoint {

  /**
   * Setup the {@link ModuleDemo}s collection and map each one with the
   * appropriate url and {@link EntryPoint}.
   */
  public MdlGwtDemo() {
    entries.add(new ModuleDemo(ABOUT, new AboutDemo()));
    entries.add(new ModuleDemo(BUTTONS, new ButtonDemo()));
    entries.add(new ModuleDemo(MENUS, new MenuDemo()));
    entries.add(new ModuleDemo(TXTFLDS, new TextfieldDemo()));
    entries.add(new ModuleDemo(TOGGLES, new ToggleDemo()));
    entries.add(new ModuleDemo(TOOLTIPS, new TooltipDemo()));
    entries.add(new ModuleDemo(DROPS, new DropdownDemo()));
    entries.add(new ModuleDemo(SLIDERS, new SliderDemo()));
    entries.add(new ModuleDemo(FLIPS, new FlipDemo()));
  }

  /**
   * Depending on the current url, invokes the appropriate {@link ModuleDemo} to
   * handle the demo GWT part.
   */
  @Override
  public final void onModuleLoad() {

    String ref = Window.Location.getHref();

    for (ModuleDemo module : entries) {
      if (module.isIncludedIn(ref)) {
        module.onModuleLoad();
        break;
      }
    }
  }

  /**
   * List of GWT modules to choose from when a demo page is loaded.
   */
  private List<ModuleDemo> entries = new ArrayList<ModuleDemo>();
}
