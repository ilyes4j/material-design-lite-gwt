package org.zerowarning.gwt.mdl.demo.navigation.main;

import org.zerowarning.gwt.mdl.demo.navigation.INavigationItem;

import com.google.gwt.user.client.ui.Anchor;

/**
 * An item that goes inside the {@link MainBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MainbarItem extends Anchor implements INavigationItem {

	/**
	 * Setup the link and its look
	 */
	public MainbarItem() {
		setStylePrimaryName("demo-mainbar-item");
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
		setHref(url);
	}

	@Override
	public void setActive(boolean active) {

		setStyleDependentName("active", !active);

		if (!active) {
			setHref("javascript:;");
		}
	}

	private String url;
}
