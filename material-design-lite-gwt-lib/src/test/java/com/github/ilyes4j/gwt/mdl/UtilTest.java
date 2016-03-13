package org.zerowarning.gwt.mdl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Only a POC.<br>
 * <br>
 * This class is intended to demonstrate that regular non-gwt tests can stand
 * side by side with gwt tests. non-gwt tests are exclusively handled by maven
 * surfire plugin while gwt tests are exclusively handled by maven gwt plugin.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class UtilTest {

  /**
   * Tautology made to prove non -gwt unit testing is working side by side with
   * gwt testing.
   */
  @Test
  public final void testSomething() {

    Assert.assertTrue(true);
  }
}
