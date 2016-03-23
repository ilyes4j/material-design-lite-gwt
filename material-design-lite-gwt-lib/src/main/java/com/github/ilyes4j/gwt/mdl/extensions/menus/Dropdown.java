package com.github.ilyes4j.gwt.mdl.extensions.menus;

import static com.github.ilyes4j.gwt.mdl.components.MdlGwtUtils.assertIndex;
import static com.github.ilyes4j.gwt.mdl.components.buttons.Button.createRaised;
import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.IMenu;
import com.github.ilyes4j.gwt.mdl.components.menus.ItemClickEvent;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu.ItemClickListener;
import com.google.gwt.user.client.ui.Composite;

/**
 * Is a {@link MenuCombo} that has the ability to store the selected item. When
 * {@link Dropdown} is initially setup, the first enabled item is set to be the
 * selected item by default.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class Dropdown extends Composite implements IMenu {

  /**
   * Setup a default dropdown with a raised action {@link Button} and a menu
   * anchored to the bottom-left of the action button.
   */
  public Dropdown() {

    button = createRaised(BTN_NO_COLOR, HAS_RIPPLE, null);

    init(button);
  }

  @Override
  public final void setAnchor(final MenuAnchor anchor) {
    combo.setAnchor(anchor);
  }

  @Override
  public final void clearMenu() {
    combo.clearMenu();
  }

  @Override
  public final void addItemClickListener(final ItemClickListener listener) {
    combo.addItemClickListener(listener);
  }

  @Override
  public final int getItemCount() {
    return combo.getItemCount();
  }

  @Override
  public final String getItemText(final int index) {
    return combo.getItemText(index);
  }

  @Override
  public final String getValue(final int index) {
    return combo.getValue(index);
  }

  @Override
  public final boolean setEnabled(final int index, final boolean enabled) {
    return combo.setEnabled(index, enabled);
  }

  @Override
  public final boolean isEnabled(final int index) {
    return combo.isEnabled(index);
  }

  @Override
  public final void addItem(final String text, final String value,
      final boolean enabled) {
    combo.addItem(text, value, enabled);

    // if no item is selected, then by default select the first enabled item in
    // the menu, otherwise don't do anything.
    if (selectedIndex != -1) {
      return;
    }

    // if the item is disabled
    if (!enabled) {
      return;
    }

    selectedIndex = getItemCount() - 1;
    button.setText(text);
  }

  /**
   * Has the same effect as Dropdown.addItem(item , item, enabled).
   * 
   * @param item
   *          the value and text of the item to be added
   * 
   * @param enabled
   *          the state of the item to be added
   */
  public final void addItem(final String item, final boolean enabled) {
    addItem(item, item, enabled);
  }

  /**
   * Has the same effect as Dropdown.addItem(item , true).
   * 
   * @param item
   *          the value and text of the item to be added
   */
  public final void addItem(final String item) {
    addItem(item, true);
  }

  /**
   * Shortcut for {@link Dropdown#addItem(String, boolean)} that adds an enabled
   * item to the menu.
   * 
   * @param value
   *          the value of the item to be added.
   * 
   * @param text
   *          the text of the item to be added.
   */
  public final void addItem(final String text, final String value) {
    addItem(text, value, true);
  }

  /**
   * @return the index of the currently selected item
   */
  public final int getSelectedIndex() {
    return selectedIndex;
  }

  /**
   * Set a selected item of the dropdown programmatically. If the chosen item is
   * disabled, the element is not selected
   * 
   * @param index
   *          the index of the item to be selected
   */
  public final void setSelected(final int index) {
    assertIndex(getItemCount(), index);

    if (selectedIndex == index) {
      return;
    }

    if (!isEnabled(index)) {
      return;
    }

    selectedIndex = index;
    button.setText(getItemText(index));
  }
  
  /**
   * 
   * @return returns the currently selected item
   */
  public final int getSelected() {
    return selectedIndex;
  }
  
  /**
   * @param btn
   *          the button part of the dropdown
   */
  private void init(final Button btn) {
    button = btn;

    combo = new MenuCombo(button);
    initWidget(combo);

    ItemClickListener clickListener;
    clickListener = new ItemClickListener() {

      @Override
      public void onItemClicked(final ItemClickEvent event) {

        setSelected(event.getIndex());
      }
    };
    addItemClickListener(clickListener);
  }

  /**
   * The action button of the dropdown.
   */
  private Button button;

  /**
   * The menu combo part of the dropdown.
   */
  private MenuCombo combo;

  /**
   * holds the index of the selected item of the dropdown.
   */
  private int selectedIndex = -1;
}
