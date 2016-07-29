package com.github.ilyes4j.gwt.mdl.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * A bundle holding the GSS resource bundle of the demo application. Not only it
 * exposes the CSS resources, but also provides a fully operational static
 * {@link Demo} instance thanks to the inner {@link Util} class that creates the
 * {@link ClientBundle} using {@link GWT#create(Class)} and also make sure the
 * css resource bundle is injected into the host page using
 * {@link CssResource#ensureInjected()}. Using this design pattern, no extra
 * effort is required to use the rules of the css resource bundle.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public interface Demo extends ClientBundle {

  /** @return the CSS bundle */
  @Source("main-gwt.gss")
  DemoResource css();

  /** The demo bundle. */
  Demo DEMO = Util.init();

  /**
   * Helper class that exposes a method to initialize the static member
   * {@link Demo#DEMO} of the client bundle.
   * 
   * @author Mohamed Ilyes DIMASSI
   *
   */
  class Util {

    /** Default private constructor for the helper class. */
    private Util() {
    }

    /**
     * @return initialize the {@link Demo} static member and insure its CSS
     *         bundle is injected into the host page.
     */
    public static final Demo init() {
      Demo demo = GWT.create(Demo.class);
      demo.css().ensureInjected();
      return demo;
    }
  }
}
