package com.github.ilyes4j.gwt.mdl.demo.navigation.main;

import com.github.ilyes4j.gwt.mdl.demo.navigation.INavigationItem;
import com.google.gwt.user.client.ui.Anchor;

/**
 * An item that goes inside the {@link MainBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MainbarItem extends Anchor implements INavigationItem {

  /**
   * Setup the link and its look.
   */
  public MainbarItem() {
    setStylePrimaryName("demo-mainbar-item");
  }

  @Override
  public final String getUrl() {
    return url;
  }

  @Override
  public final void setUrl(final String inputUrl) {
    this.url = inputUrl;
    setHref(inputUrl);
  }

  @Override
  public final void setActive(final boolean active) {

    setStyleDependentName("active", !active);

    if (!active) {
      setHref("javascript:;");
    }
  }

  /**
   * The url of the tab item inside the tab bar.
   */
  private String url;
}
