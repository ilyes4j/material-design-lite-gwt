package org.zerowarning.gwt.mdl.demo;

import org.zerowarning.gwt.mdl.demo.navigation.UrlManager;

import com.google.gwt.core.client.EntryPoint;

/**
 * Stores the relationship between a demo url and the {@link EntryPoint} that
 * should be executed to handle that url. For further explanations see
 * {@link MdlGwtDemo}.<br>
 * <br>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @see MdlGwtDemo
 *
 */
public class ModuleDemo implements EntryPoint {

  /**
   * Setup a module with no parameters.
   */
  public ModuleDemo() {
    super();
  }

  /**
   * Setup a module and initialize it with all the required informations.
   * 
   * @param moduleUrl
   *          the target url to handle
   * 
   * @param inputModule
   *          the module to invoque when handling the target url
   */
  public ModuleDemo(final String moduleUrl, final EntryPoint inputModule) {
    super();

    this.url = moduleUrl;
    this.urlParts = mgr.splitUrl(url, true);

    this.module = inputModule;
  }

  /**
   * Set the target url asociated with the current module.
   * 
   * @param moduleUrl
   *          the target url of the module
   */
  public final void setUrl(final String moduleUrl) {
    this.url = moduleUrl;
    this.urlParts = mgr.splitUrl(url, true);
  }

  /**
   * Set the module to be loaded and that is responsible for handling the
   * associated url.
   * 
   * @param inputModule
   *          the module to be executed for the url
   */
  public final void setModule(final EntryPoint inputModule) {
    this.module = inputModule;
  }

  /**
   * <p>
   * The goal here is to determine whether the current module is the one be be
   * executed for the current input url.
   * </p>
   * If the module's url is included in the input url it means that the module
   * matches the input url. This means that if the input url is the loaded page
   * then the module should be executed to inject the GWT logic into that page.
   * For further information see {@link MdlGwtDemo}.
   * 
   * @param inputUrl
   *          the loaded page's url
   * 
   * @return <code>true</code> if the module url is included in the loaded
   *         page's url
   */
  public final boolean isIncludedIn(final String inputUrl) {

    String[] inputParts = mgr.splitUrl(inputUrl, true);

    return mgr.urlInclusion(inputParts, urlParts) != -1;
  }

  @Override
  public final void onModuleLoad() {
    module.onModuleLoad();
  }

  /**
   * The relative url of the module.
   */
  private String url;

  /**
   * The relative url transformed into an array of parts.
   */
  private String[] urlParts;

  /**
   * The GWT module to be executed when the url is loaded.
   */
  private EntryPoint module;

  /**
   * helper for operations on urls.
   */
  private UrlManager mgr = new UrlManager();
}
