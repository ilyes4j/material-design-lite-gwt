package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextValidator;
import com.google.gwt.core.client.EntryPoint;

/** Text field validation demo. */
public class ValidateTextfieldDemo implements EntryPoint {

  /** Display an error message when the content is invalid. */
  public final void onModuleLoad() {

    // setup a text field with a label
    TextField txtfld = new TextField("Validated field...");
    // attach the field to the page
    get("validateContainer").add(txtfld);
    // make the label of the field float
    txtfld.setFloat(Float.FLOAT);
    // setup a validator
    TextValidator validator = new TextValidator();
    // set an error message when the text is invalid
    String error = "This field should contain between 4 and 8 characters";
    validator.setErrorMessage(error);
    // set the validation regexp to the validator
    validator.setPattern(".{4,8}");
    // apply the validator to the field
    txtfld.setValidator(validator);
  }
}
