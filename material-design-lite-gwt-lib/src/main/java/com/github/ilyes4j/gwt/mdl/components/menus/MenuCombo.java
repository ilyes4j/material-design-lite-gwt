package com.github.ilyes4j.gwt.mdl.components.menus;

import static com.google.gwt.dom.client.Style.Position.RELATIVE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu.ItemClickListener;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * {@link MenuCombo} makes it simpler and safer to build {@link Menu}s. It
 * absorbs the complexity of creating a {@link Menu} and its related action
 * {@link Button}. In fact, for the {@link Menu} to work properly some
 * requirements must be satisfied. With mdl, these requirement are the
 * responsibility of the developer. This component's goal is to encapsulate
 * these requirements and to hide them from the developer. By enforcing these
 * rules inside the menu, the developer's full attention goes to the application
 * logic. These requirements are as follows :<br>
 * <br>
 * <ol>
 * <li>The Button should be created first and then added to the DOM before the
 * {@link Menu} is. Otherwise, the {@link Menu} won't be able to attach its
 * event handlers to it.</li>
 * <li>The menu should live inside the same element as the its action
 * {@link Button}.</li>
 * <li>The {@link Menu} should reference the id of its related {@link Button} in
 * order for mdl to bind them together. The developer should provide an id for
 * the {@link Button} which should then be fed to the {@link Menu}.
 * {@link Button}.</li>
 * </ol>
 * 
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MenuCombo extends FlowPanel implements IMenuCombo {

  /**
   * Setup a {@link MenuCombo}.<br>
   * <br>
   * A menu combo is made of a {@link Button} and a {@link Menu} that works
   * together to display the menu to the user when the button is clicked. Using
   * this constructor, the user provides the instance of the button. The menu
   * property is managed behind the scene at the combo.
   * 
   * @param btn
   *          the action button for the menu
   */
  public MenuCombo(final Button btn) {

    if (btn == null) {
      throw new IllegalArgumentException("Undefined button");
    }

    // set the button part
    button = btn;

    // setup the menu part
    menu = new Menu();

    // make the combo the default event source
    menu.setEventSource(this);

    // build an ID for the menu. mdl requires that the button controlling
    // the menu should have an id. That id is then referenced in the menu
    // component enabling it to communicate with the button.
    menuId = ATTR_ID + counter;

    // increment the counter to provide a unique id for the next created
    // menu
    counter++;

    // ensure the parent element has a relative positioning.
    getElement().getStyle().setPosition(RELATIVE);

    // set an id to the button
    this.button.getElement().setId(menuId);

    // set the binding between the menu and the action button
    menu.setActionId(menuId);

    // add the button to the parent element
    add(button);

    // add the menu to the parent element
    add(menu);

    // make the button disabled in the absence of items in the menu
    // as soon as the menu acquires some items make it enabled back
    enableAction();
  }

  /**
   * @param inputSource
   *          the object that designated as the source of events published by
   *          the menu
   */
  public void setEventSource(final Object inputSource) {
    menu.setEventSource(inputSource);
  }

  /**
   * @param enable
   *          if <code>true</code> then the action button of the menu is set to
   *          be enabled, <code>false</code> then the action button is disabled
   */
  public void setEnabled(final boolean enable) {
    button.setEnabled(enable);
  }

  /**
   * @return <code>true</code> if the menu's action button is enabled,
   *         <code>false</code> if it is disabled.
   */
  public boolean isEnabled() {
    return button.isEnabled();
  }

  @Override
  public final void setAnchor(final MenuAnchor anchor) {
    menu.setAnchor(anchor);
  }

  @Override
  public final void clearMenu() {
    menu.clearMenu();
    enableAction();
  }

  @Override
  public final void addItem(final String text, final String value,
      final boolean enabled) {
    addItem(text, value, getItemCount(), enabled);
  }

  @Override
  public final void addItem(final String item, final boolean enabled) {
    addItem(item, item, enabled);
  }

  @Override
  public void addItem(final String text, final String value, final int index,
      final boolean enabled) {
    menu.addItem(text, value, index, enabled);
    enableAction();
  }

  @Override
  public final void addItemClickListener(final ItemClickListener listener) {
    menu.addItemClickListener(listener);
  }

  @Override
  public final int getItemCount() {
    return menu.getItemCount();
  }

  @Override
  public final String getItemText(final int index) {
    return menu.getItemText(index);
  }

  @Override
  public final String getValue(final int index) {
    return menu.getValue(index);
  }

  @Override
  public final boolean setEnabled(final int index, final boolean enabled) {
    return menu.setEnabled(index, enabled);
  }

  @Override
  public final boolean isEnabled(final int index) {
    return menu.isEnabled(index);
  }

  @Override
  public void removeItem(final int index) {
    menu.removeItem(index);
    enableAction();
  }

  @Override
  public int getTabIndex() {
    return button.getTabIndex();
  }

  @Override
  public void setAccessKey(final char key) {
    button.setAccessKey(key);
  }

  @Override
  public void setFocus(final boolean focused) {
    button.setFocus(focused);
  }

  @Override
  public void setTabIndex(final int index) {
    button.setTabIndex(index);
  }

  @Override
  public void upgrade() {
    menu.upgrade();
  }

  @Override
  public boolean isUpgraded() {
    return menu.isUpgraded();
  }

  /**
   * Make sure the action button is enabled if the menu contains at least an
   * item. Make it disabled if it does not contain any item.
   */
  private void enableAction() {
    button.setEnabled(getItemCount() > 0);
  }

  /**
   * the {@link Menu} part of the {@link MenuCombo}.
   */
  private Menu menu;

  /**
   * the {@link Button} part of the {@link MenuCombo}.
   */
  private Button button;

  /**
   * an id that enables the button and the menu to communicate.
   */
  private String menuId;

  /**
   * a suffix for the generated id.
   */
  private static final String ATTR_ID = "btn_menu_";

  /**
   * A counter to generate unique {@link MenuCombo} ids.
   */
  private static int counter = 0;
}
