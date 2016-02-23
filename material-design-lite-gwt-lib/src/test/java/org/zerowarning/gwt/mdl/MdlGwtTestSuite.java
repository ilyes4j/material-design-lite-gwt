package org.zerowarning.gwt.mdl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * As explained <a href=
 * "https://gwt-maven-plugin.github.io/gwt-maven-plugin/user-guide/testing.html">
 * here</a>, it is best to combine all GWT Tests under a test suite to speed up
 * testing.
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

	private static final String SUITE_NAME = "The library module suite";
}
