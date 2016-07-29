package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.google.gwt.core.client.EntryPoint;

/** A floating label for the text field. */
public class FloatTextfieldDemo implements EntryPoint {

  /** Set the label to float over the text box. */
  public final void onModuleLoad() {

    // Make a text field with a description label
    TextField txtfld = new TextField("They all float down here...");
    // make the label float
    txtfld.setFloat(Float.FLOAT);
    // attach the field to the page
    get("floatContainer").add(txtfld);
  }
}
