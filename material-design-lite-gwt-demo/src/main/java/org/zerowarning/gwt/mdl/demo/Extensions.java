package org.zerowarning.gwt.mdl.demo;

import org.zerowarning.gwt.mdl.components.menus.ItemClickEvent;
import org.zerowarning.gwt.mdl.components.menus.Menu;
import org.zerowarning.gwt.mdl.components.menus.MenuItem;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class Extensions implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel extensPanel = RootPanel.get("extensContainer");

		Menu menu = new Menu("Choose option");
		menu.getElement().setAttribute("style", "padding-right: 4px;");

		menu.addItem(new MenuItem("First option"));
		menu.addItem(new MenuItem("Second option"));
		menu.addItem(new MenuItem("Third option"));

		extensPanel.add(menu);

		final Label lbl = new Label();
		lbl.setText("Choose option");
		lbl.addStyleName("mdl-typography--headline");
		lbl.addStyleName("mdl-gwt-select-status");
		extensPanel.add(lbl);

		menu.addItemClickListener(new Menu.ItemClickListener() {

			@Override
			public void onItemClicked(ItemClickEvent event) {
				lbl.setText(event.getValue());
			}
		});
	}
}