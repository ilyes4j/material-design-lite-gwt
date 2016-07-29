package com.github.ilyes4j.gwt.mdl.demo.navigation.components;

import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createMiniFab;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.google.gwt.user.client.Window.Location.assign;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.demo.navigation.INavigationItem;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A {@link ComponentsItem} is a link the demo page of a gwt-mdl component. It
 * is intended to be placed inside a {@link SideNavigationBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ComponentsItem extends Composite implements INavigationItem {

  /**
   * Setup the DOM structure and css selectors for the navigation item.
   * 
   * @param icon
   *          the material icon code to be set for the fab {@link Button}
   */
  public ComponentsItem(final String icon) {

    // setup the component icon
    btn = createMiniFab(ACCENT, HAS_RIPPLE, icon);

    // setup a container for the icon
    btnContainer = new FlowPanel();
    btnContainer.setStyleName(Demo.DEMO.css().compsBarItemIcon());
    // put the icon inside its container
    btnContainer.add(btn);

    // setup a container for the link caption
    captionContainer = new FlowPanel();
    captionContainer.setStyleName("demo-text");

    container = new FlowPanel();
    container.setStyleName(Demo.DEMO.css().compsBarItem());

    // put the icon container inside the link container
    container.add(btnContainer);
    // put the caption container after the icon
    container.add(captionContainer);

    // initialize the link component
    initWidget(container);
  }

  /**
   * Define the operations to be performed when the item corresponds to the
   * current displayed demo page.<br>
   * <br>
   * When the item links to the current page, change its visual appearance to
   * make it different from the links that links to other demo pages. Also, do
   * not put a click listener on the link.<br>
   * <br>
   * When the item link to another page, put a click listener on it to make it
   * navigable and make it look like all the links that does not link to the
   * current page.
   */
  @Override
  public final void setActive(final boolean active) {
    btn.setEnabled(active);
    container.setStyleDependentName("active", !active);
    if (active) {
      container.addDomHandler(new ClickHandler() {
        @Override
        public void onClick(final ClickEvent event) {
          assign(url);
        }
      }, ClickEvent.getType());
    }
  }

  /**
   * Sets the text that should be displayed besides the icon.
   * 
   * @param caption
   *          the text to be displayed for the item
   */
  public final void setCaption(final String caption) {
    captionContainer.getElement().setInnerText(caption);
  }

  /**
   * The url to go to when the link is clicked.
   * 
   * @param inputurl
   *          the url related to this item.
   */
  @Override
  public final void setUrl(final String inputurl) {
    this.url = inputurl;
  }

  /**
   * @return the url related to the item.
   */
  @Override
  public final String getUrl() {
    return this.url;
  }

  /**
   * The url of the component demo page.
   */
  private String url;

  /**
   * The DOM element containing the label of the link.
   */
  private FlowPanel captionContainer;

  /**
   * The button containing the icon of the link.
   */
  private Button btn;

  /**
   * The link container.
   */
  private FlowPanel container;

  /**
   * The DOM element containing the button.
   */
  private FlowPanel btnContainer;
}
