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
public class MenuCombo extends FlowPanel implements IMenu {

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
  }

  @Override
  public final void setAnchor(final MenuAnchor anchor) {
    menu.setAnchor(anchor);
  }

  @Override
  public final void clearMenu() {
    menu.clear();
  }

  @Override
  public final void addItem(final String text, final String value,
      final boolean enabled) {
    menu.addItem(text, value, enabled);
  }

  /**
   * Has the same effect as MenuCombo.addItem(item , item, enabled).
   * 
   * @param item
   *          the value and text of the item to be added
   * 
   * @param enabled
   *          the state of the item to be added
   */
  public final void addItem(final String item, final boolean enabled) {
    menu.addItem(item, enabled);
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
