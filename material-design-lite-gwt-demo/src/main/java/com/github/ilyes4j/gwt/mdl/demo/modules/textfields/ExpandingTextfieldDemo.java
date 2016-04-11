package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.ExpandingTextField;
import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextValidator;
import com.google.gwt.core.client.EntryPoint;

/** Expanding text field demo. */
public class ExpandingTextfieldDemo implements EntryPoint {

  /** Add a validated exapnding text field. */
  public final void onModuleLoad() {

    // prepare an expanding text field with a material icon
    ExpandingTextField expanding = new ExpandingTextField("search");
    // make the label float on focus
    expanding.setFloat(Float.FLOAT);
    // set the label
    expanding.setLabel("Expanding...");

    // setup a text validation
    TextValidator validator = new TextValidator();
    // that insure exactly 5 letter to be input
    validator.setPattern(".{5,5}");
    // set the error message to be displayed if the input is invalid
    validator.setErrorMessage("Should be 5 characters long !");
    // attach the validator to the text field
    expanding.setValidator(validator);
    // attach the text field to the page
    get("expandingContainer").add(expanding);
  }
}
