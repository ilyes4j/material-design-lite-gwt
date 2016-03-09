package org.zerowarning.gwt.mdl.components.menus;

import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * {@link MenuItem} is an item in the list of items in an {@link IMenu}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MenuItem extends HTMLPanel {

  /**
   * Create an item and set its label.
   * 
   * @param inputValue
   *          The value of the item.
   * 
   * @param text
   *          The displayed label for the item.
   */
  public MenuItem(final String inputValue, final String text) {
    // the container is a list item tag
    super(LIElement.TAG, "");

    // that has the menu item material css style
    addStyleName(CSS_MENU_ITEM);

    // the item contains a span that holds the label to be displayed.
    content = new HTMLPanel(SpanElement.TAG);

    // add the text container to the item container
    add(content);

    // set the label to the provided text
    content.getElement().setInnerText(text);

    // the value of the item
    this.value = inputValue;
  }

  /**
   * Sets the state of the item.
   * 
   * @param enabled
   *          if true responds to click events, otherwise it is grayed and will
   *          not respond to click events.
   * 
   * @return <code>true</code> to indicate that the input state was applied,
   *         <code>false</code> meaning that the input state is the same as the
   *         current state, therefore nothing was changed.
   * 
   * @see MenuItem#isEnabled()
   */
  public final boolean setEnabled(final boolean enabled) {

    boolean isDisabled = getElement().hasAttribute(ATTR_DISABLED);

    // if the requested state is identical to the actual state then leave
    // without doing anything and return false to indicate that nothing was
    // performed
    if (enabled == !isDisabled) {
      return false;
    }

    // if the item is disabled and a request is made to enable it then
    // remove the disabled attribute
    if (enabled && isDisabled) {
      getElement().removeAttribute(ATTR_DISABLED);
    } else if (!enabled && !isDisabled) {
      // if the item is enabled and a request is made to disable it then
      // add a disabled attribute

      getElement().setAttribute(ATTR_DISABLED, "true");
    }

    return true;
  }

  /**
   * If an item is set to be disabled, it will be grayed and won't dispatch an
   * {@link ItemClickEvent} when clicked. Besides, clicking on the item still
   * closes the menu.
   * 
   * @return <code>true</code> if the item is enabled, <code>false</code>
   *         otherwise.
   */
  public final boolean isEnabled() {
    return !getElement().hasAttribute(ATTR_DISABLED);
  }

  /**
   * Returns the value of the item.
   * 
   * @return the value of the item.
   */
  public final String getValue() {
    return value;
  }

  /**
   * Returns the displayed text of the item.
   * 
   * @return the label of the item.
   */
  public final String getText() {
    return content.getElement().getInnerText();
  }

  /**
   * span tag to hold the displayed label of the item.
   */
  private HTMLPanel content;

  /**
   * The value of the item.
   */
  private String value;

  /**
   * menu item mdl css style.
   */
  private static final String CSS_MENU_ITEM = "mdl-menu__item";

  /**
   * disabled attribute name.
   */
  private static final String ATTR_DISABLED = "disabled";
}
