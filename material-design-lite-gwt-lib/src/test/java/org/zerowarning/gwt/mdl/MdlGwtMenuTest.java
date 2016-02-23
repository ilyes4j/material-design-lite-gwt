package org.zerowarning.gwt.mdl;

import org.zerowarning.gwt.mdl.components.menus.Menu;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * Tests for the {@link Menu} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtMenuTest extends MdlGwtBaseTest {

	/**
	 * The menu should not allow being upgraded without insuring it is bound to
	 * an action button.
	 */
	public void testNoActionId() {

		try {

			// setup a menu
			Menu menu = new Menu();

			// attach the menu before associating it to a button.
			RootPanel.get().add(menu);

			// fail the test if the menu does not rise an exception
			assertTrue(false);

		} catch (IllegalStateException ise) {

			// pass the test when the menu raises the appropriate exception
			assertTrue(true);
		}
	}
}
