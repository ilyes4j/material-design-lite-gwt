package com.github.ilyes4j.gwt.mdl;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * To avoid repetition, the module name is encapsulated here and each class
 * inheriting {@link MdlGwtBaseTest} will be associated by default to the GWT
 * module to be tested.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtBaseTest extends GWTTestCase {

  /**
   * Get the module name for which and under which the tests will be executed.
   */
  @Override
  public final String getModuleName() {
    return MDL_MODULE;
  }

  /**
   * Which module is this Test attached to.
   */
  private static final String MDL_MODULE = "com.github.ilyes4j.gwt.mdl.MdlUnit";
}
