package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.google.gwt.core.client.EntryPoint;

/** Default text field demo. */
public class DefaultTextfieldDemo implements EntryPoint {

  /** When the page loads add the text field. */
  public final void onModuleLoad() {

    // setup a text field, provide a label and attach it to the page
    get("defaultContainer").add(new TextField("Default"));
  }
}
