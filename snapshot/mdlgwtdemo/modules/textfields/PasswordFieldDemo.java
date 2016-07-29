package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.PasswordField;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextValidator;
import com.google.gwt.core.client.EntryPoint;

/** Password field demo. */
public class PasswordFieldDemo implements EntryPoint {

  /** When the page loads add the password field. */
  public final void onModuleLoad() {

    // setup a password input field and it's label
    PasswordField passField = new PasswordField("Enter your password...");
    // make the label float
    passField.setFloat(Float.FLOAT);
    // setup a specific text validator
    TextValidator validator = new TextValidator();
    // set the error massage to be displayed when the input text is invalid
    String err = "Expected alpha-numeric between 8 and 16 characters";
    validator.setErrorMessage(err);
    // build the validation regexp
    validator.setPattern("[A-Za-z0-9]{8,16}");
    // apply the validator on the field
    passField.setValidator(validator);
    // attach the field to the page
    get("passwordContainer").add(passField);
  }
}
