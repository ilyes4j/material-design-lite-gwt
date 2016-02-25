package org.zerowarning.gwt.mdl.demo.navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * To understand how {@link NavigationBar} works, it is mandatory to realize
 * what issue it tries to solve.<br>
 * <br>
 * 
 * A navigation bar is meant to hold a collection of links and make it easy to
 * switch between these links. That navigation bar is then embedded in each page
 * it links to. Each page will have its own copy of the navigation bar. The
 * simplest solution to achieve this result is to express the link collection
 * statically against the root of the host. For many cases, this is a fine
 * solution, but for many others, this will turn out to be a very restrictive
 * condition to fulfill.<br>
 * <br>
 * What if the location of the navigable collection is not set in advance or
 * meant to change very often ? <br>
 * <br>
 * What if the host makes it impossible to express the links relative to its
 * root ? <br>
 * <br>
 * For example github.com considers that the root of the application is
 * username.github.io/, when in fact it hosts the project at
 * username.github.io/project. If we where to write the link relative to the
 * host root, we would need to include <code>/project/</code> in each and every
 * link in the bar.<br>
 * <br>
 * This is even more hard to manage considering that when the application is run
 * elsewhere, the prefix needs to be changed to fit the context. Even switching
 * from a local setup to a production environment might require rewriting the
 * links which can be tedious and error prone. For these reasons, using static
 * urls is not a safe nor a productive workaround. The links in a navigation bar
 * must be written related to each other rather than being expressed relative to
 * the site's root.<br>
 * <br>
 * When a page of the link collection is opened, the instance of the navigation
 * bar it contains should have it's links written so that navigating from one
 * link to its siblings is expressed relative to that link. This is the safest
 * solution to deal with the "root uncertainty". <br>
 * <br>
 * When done manually, this solution sadly fails to scale. If the structure of
 * the site grows bigger or needs to be restructured, this solution becomes a
 * maintenance nightmare. If the navigation bar was to be embedded in every page
 * on the site, then all the links it contains should be rewritten relative to
 * the current page it lives inside. For a couple of pages, this solution is
 * perfectly fine, but for a couple of dozen of pages, it becomes very quickly
 * unmanageable. <br>
 * <br>
 * This is what {@link NavigationBar} basically does for you. In each page it is
 * embedded in, {@link NavigationBar} rewrites all the links it contains based
 * on the current url.<br>
 * <br>
 * 
 * How it works ?<br>
 * <br>
 * 
 * <ol>
 * <li>First, the designer of the application builds a navigation bar that
 * extends {@link NavigationBar}.</li>
 * <li>He, then, set it up with the collection of links it is supposed to switch
 * between.
 * <li>When setting up the links, the designer expresses the links relative to a
 * common ancestor.</li>
 * <li>The designer, then, embeds the {@link NavigationBar} in each page it
 * needs to appear.
 * <li>Before, the page is loaded, the navigation contains the initial set of
 * links it was setup with.</li>
 * <li>When the page loads, the navigation bar rewrites each link to express it
 * relative to the current page as would have done the developer himself
 * manually.</li>
 * <li>It also decorates the link relative to the current page to visually
 * indicate it is the open link.</li>
 * <li>The navigation bar can also be embedded inside a page that does not
 * belong to the links collection but rather in the folder tree of one of the
 * links. The navigation bar still is able to find and highlight the appropriate
 * link it belongs to and correctly rewrites the remaining links of the
 * navigation bar. This feature, enables us to make complex
 * {@link NavigationBar} trees embedded one inside the other. Each
 * {@link NavigableMap} will highlight the appropriate link and rewright the
 * remaining ones.</li>
 * </ol>
 * <br>
 * 
 * @author Moahmed Ilyes DIMASSI.
 *
 * @param <T>
 *            A subtype of {@link INavigationItem}.
 */
public class NavigationBar<T extends INavigationItem> extends Composite {

	/**
	 * Setup the navigation bar.
	 */
	public NavigationBar() {
		initWidget(container);
	}

	/**
	 * Add another link to the bar
	 * 
	 * @param link
	 *            The link tobe added.
	 */
	public void addLink(T link) {
		links.add(link);
		container.add(link);
	}

	/**
	 * When the navigation bar is attached to the DOM, it rewrites the links it
	 * manages. All items should be added before the navigation bar is added to
	 * the DOM, after this point, the bar can no longer be tweaked.
	 */
	@Override
	protected void onLoad() {
		super.onLoad();

		// rewrite the links when the bar is attached to the DOM.
		rewriteLinks();
	}

	/**
	 * Rewrite the links managed by the bar.
	 */
	private void rewriteLinks() {

		String ref = Window.Location.getHref();

		String[] refsplits = urlMgr.splitUrl(ref, false);

		String itemurl;
		String[] itemsplits;
		int upCount;
		INavigationItem item;
		int activeItemIdx = -1;
		int currStartIdx;
		int activeStartIdx = -1;

		for (int i = 0; i < links.size(); i++) {
			item = links.get(i);
			itemurl = item.getUrl();
			itemsplits = urlMgr.splitUrl(itemurl, false);
			currStartIdx = urlMgr.urlInclusion(refsplits, itemsplits);

			if (currStartIdx != -1) {
				activeStartIdx = currStartIdx;
				activeItemIdx = i;
				item.setActive(false);
				break;
			}

		}

		if (activeItemIdx == -1) {
			return;
		}

		String itemResult;

		for (int i = 0; i < links.size(); i++) {
			if (i == activeItemIdx) {
				continue;
			}

			item = links.get(i);

			upCount = refsplits.length - activeStartIdx;
			itemResult = urlMgr.stepBack(upCount, item.getUrl());
			item.setUrl(itemResult);
			item.setActive(true);
		}
	}

	protected FlowPanel container = new FlowPanel();

	private List<T> links = new ArrayList<>();

	private UrlManager urlMgr = new UrlManager();
}
