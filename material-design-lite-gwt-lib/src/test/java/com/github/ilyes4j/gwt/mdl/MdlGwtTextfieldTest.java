package com.github.ilyes4j.gwt.mdl;

import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;

/**
 * Tests for the {@link TextField} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtTextfieldTest extends MdlGwtBaseTest {

  /**
   * Make sure that setting the text on the textfield doesn't raise an issue
   * considering that the native MaterialTextfield.checkDirty() function is
   * called to sync the label position.
   */
  public final void testSetTextBeforeUpgarde() {
    
    TextField fieldText = new TextField("Default");

    try {
      //set the text and make sure no exception is raised
      fieldText.setText("Some Text");
      
      //if the call is successful succeed the test
      assertTrue(true);

    } catch (Exception e) {
      
      //if an exception is raised fail the test
      assertFalse(true);
    }
  }
}
