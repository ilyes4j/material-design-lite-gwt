package org.zerowarning.gwt.mdl.components.menus;

import static com.google.gwt.dom.client.Style.Position.RELATIVE;

import org.zerowarning.gwt.mdl.components.buttons.Button;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Simplifies the creation of {@link Menu}s and makes them safer. It absorbs the
 * complexity of creating a {@link Menu} and its related action {@link Button}.
 * In fact creating a menu with mdl has some assumptions about the required
 * conditions to be satisfied in order for the {@link Menu} to work properly.
 * These requirement are left to the responsibility of the developer to satisfy.
 * This component goal is to encapsulate these requirements and to hide them
 * from the developer as it enforces them itself, leaving the developer's full
 * attention on the application logic. These requirements are as follows<br>
 * <br>
 * <ol>
 * <li>The Button should be created first and added to the DOM before the
 * {@link Menu} is. Otherwise, the {@link Menu} won't be able to attach its
 * event handlers to it.</li>
 * <li>The menu should live inside the same element as the its action
 * {@link Button}.</li>
 * <li>The {@link Menu} should reference the id of its related {@link Button} in
 * order for mdl to bind them together. The developer should provide an id for
 * the {@link Button} that should be then fed to the {@link Menu}.
 * {@link Button}.</li>
 * </ol>
 * 
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MenuCombo extends FlowPanel {

	public MenuCombo(Menu mn, Button btn) {

		if (btn == null) {
			throw new IllegalArgumentException("Undefined button");
		}

		if (mn == null) {
			throw new IllegalArgumentException("Undefined menu");
		}

		// set the button part
		button = btn;

		// set the menu part
		menu = mn;

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
		menu.getElement().setAttribute("for", menuId);

		// add the button to the parent element
		add(button);

		// add the menu to the parent element
		add(menu);
	}

	/**
	 * the {@link Menu} part of the {@link MenuCombo}
	 */
	private Menu menu;

	/**
	 * the {@link Button} part of the {@link MenuCombo}
	 */
	private Button button;

	/**
	 * an id that enables the button and the menu to communicate
	 */
	private String menuId;

	/**
	 * a suffix for the generated id
	 */
	private static final String ATTR_ID = "btn_menu_";

	/**
	 * A counter to generate unique {@link MenuCombo} ids.
	 */
	private static int counter = 0;
}
