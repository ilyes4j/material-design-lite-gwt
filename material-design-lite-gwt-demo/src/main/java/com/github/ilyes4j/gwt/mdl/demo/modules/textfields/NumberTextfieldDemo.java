package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextValidator;
import com.google.gwt.core.client.EntryPoint;

/** A number field as a demonstration for the validation feature. */
public class NumberTextfieldDemo implements EntryPoint {

  /** Set a number validator for the text field. */
  public final void onModuleLoad() {

    // setup a text field with a label
    TextField txtfld = new TextField("Number");
    // attach the field to the page
    get("numberContainer").add(txtfld);
    // make the label float
    txtfld.setFloat(Float.FLOAT);
    // setup a number validation
    TextValidator validator = new TextValidator();
    // set the error message to show when the input is not a number
    validator.setErrorMessage("This is not a number");
    // set the number validation pattern
    validator.setPattern("-?[0-9]*(\\.[0-9]+)?");
    // connect the validator to the field
    txtfld.setValidator(validator);
  }
}
