package org.zerowarning.gwt.mdl.demo.navigation;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * {@link INavigationItem}, a navigation item, is a link in a link bar,
 * {@link NavigationBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public interface INavigationItem extends IsWidget {

	/**
	 * Retrieve the url of the link.
	 * 
	 * @return the url associated to this item
	 */
	public String getUrl();

	/**
	 * Sets the url of the page to go to when this link is clicked.
	 * 
	 * @param url
	 *            the page to go to when the link is clicked.
	 */
	public void setUrl(String url);

	/**
	 * The {@link NavigationBar} has to know wether a {@link INavigationItem}
	 * points to the current page or another one. When the item points to the
	 * current page it is said to be inactive, otherwise it is active.
	 * 
	 * @param active
	 *            <code>true</code> to indicate the item does not point to the
	 *            current page, <code>false</code> otherwise.
	 */
	public void setActive(boolean active);
}
