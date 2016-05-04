package com.github.ilyes4j.gwt.mdl.demo.utils;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.demo.navigation.components.ComponentsItem;
import com.github.ilyes4j.gwt.mdl.demo.navigation.components.SideNavigationBar;
import com.github.ilyes4j.gwt.mdl.demo.navigation.main.MainBar;
import com.github.ilyes4j.gwt.mdl.demo.navigation.main.MainbarItem;

/**
 * Reusable code for the demos.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public final class MdlGwtDemoUtils {

  /**
   * Private constructor for utiliy class.
   */
  private MdlGwtDemoUtils() {
  }

  /**
   * Stores the id of the main section of the demo page. This is the id of the
   * DOM element under which the side bar is sitting.
   */
  public static final String MAIN = "demo-main";

  /**
   * Stores the id of the header under which the main navigation bar is sitting.
   */
  public static final String HEADER = "header-link-row";

  /**
   * relative location of the about page.
   */
  public static final String ABOUT = "about/about.html";

  /**
   * relative location of the components page.
   */
  public static final String COMPONENTS = "components/components.html";

  /**
   * relative location of the extensions page.
   */
  public static final String EXTENSIONS = "extensions/extensions.html";

  /**
   * relative location of the buttons demo page.
   */
  public static final String BUTTONS = "components/buttons/buttons.html";

  /**
   * relative location of the menus demo page.
   */
  public static final String MENUS = "components/menus/menus.html";

  /**
   * relative location of the textfields demo page.
   */
  public static final String TXTFLDS = "components/textfields/textfields.html";

  /**
   * relative location of the toggles demo page.
   */
  public static final String TOGGLES = "components/toggles/toggles.html";

  /**
   * relative location of the tooltip demo page.
   */
  public static final String TOOLTIPS = "components/tooltips/tooltips.html";

  /**
   * relative location of the slider demo page.
   */
  public static final String SLIDERS = "components/sliders/sliders.html";
  
  /**
   * relative location of the dropdown demo page.
   */
  public static final String DROPS = "extensions/dropdowns/dropdowns.html";
  
  /**
   * Setup the components side bar and inject it inside the main section of a
   * demo page.
   */
  public static void insertComponentsNavbar() {

    SideNavigationBar bar = new SideNavigationBar();

    // setup the button link.
    ComponentsItem button = new ComponentsItem("keyboard_arrow_right");
    // the text of the link
    button.setCaption("Buttons");
    // the url of the link relative to "components" node
    button.setUrl(BUTTONS);
    // add the link to the navigation bar
    bar.addLink(button);

    // setup the menu link
    ComponentsItem menu = new ComponentsItem("menu");
    menu.setCaption("Menus");
    menu.setUrl(MENUS);
    bar.addLink(menu);

    // setup the textfield link
    ComponentsItem textfield = new ComponentsItem("text_format");
    textfield.setCaption("Textfields");
    textfield.setUrl(TXTFLDS);
    bar.addLink(textfield);

    // setup the textfield link
    ComponentsItem toggle = new ComponentsItem("check_circle");
    toggle.setCaption("Toggles");
    toggle.setUrl(TOGGLES);
    bar.addLink(toggle);

    // setup the tooltip link
    ComponentsItem tooltip = new ComponentsItem("textsms");
    tooltip.setCaption("Tooltips");
    tooltip.setUrl(TOOLTIPS);
    bar.addLink(tooltip);

    // setup the slider link
    ComponentsItem slider = new ComponentsItem("tune");
    slider.setCaption("Sliders");
    slider.setUrl(SLIDERS);
    bar.addLink(slider);
    
    // insert the side bar under the main section of the demo page
    get(MAIN).insert(bar, 0);
  }

  /**
   * Setup the extensions side bar and inject it inside the main section of a
   * demo page.
   */
  public static void insertExtensionsNavbar() {

    SideNavigationBar bar = new SideNavigationBar();

    ComponentsItem dropdown = new ComponentsItem("keyboard_arrow_right");
    dropdown.setCaption("Dropdowns");
    dropdown.setUrl(DROPS);
    bar.addLink(dropdown);

    // insert the side bar under the main section of the demo page
    get(MAIN).insert(bar, 0);
  }

  /**
   * Setup the main bar of the demo and inject it inside the header.
   */
  public static void insertMainbar() {

    // setup the main bar
    MainBar mainbar = new MainBar();

    // setup the link to the about section
    MainbarItem aboutItem = new MainbarItem();
    aboutItem.setUrl(ABOUT);
    aboutItem.setText("about");
    mainbar.addLink(aboutItem);

    // setup the link to the components section
    MainbarItem compsItem = new MainbarItem();
    compsItem.setUrl(COMPONENTS);
    compsItem.setText("components");
    mainbar.addLink(compsItem);

    // setup the link to the extensions section
    MainbarItem extsItem = new MainbarItem();
    extsItem.setUrl(EXTENSIONS);
    extsItem.setText("extensions");
    mainbar.addLink(extsItem);

    // insert the main bar under the header section of the demo page
    get(HEADER).insert(mainbar, 0);
  }
}
