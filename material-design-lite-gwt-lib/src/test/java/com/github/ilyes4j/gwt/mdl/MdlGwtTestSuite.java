package com.github.ilyes4j.gwt.mdl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * As explained <a href= "http://tinyurl.com/zrn76n5"> here</a>, it is best to
 * combine all GWT Tests under a test suite to speed up testing.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtTestSuite extends TestCase {

  /**
   * 
   * @return a test suite containing all the GWT tests
   */
  public static Test suite() {
    TestSuite suite = new TestSuite(SUITE_NAME);
    suite.addTestSuite(MdlGwtMenuTest.class);
    return suite;
  }

  /**
   * The text to be displayed when the test suit is running.
   */
  private static final String SUITE_NAME = "The library module suite";
}
