package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.MultilineTextField;
import com.google.gwt.core.client.EntryPoint;

/** Text area demo. */
public class AreaTextfieldDemo implements EntryPoint {

  /** Add a text area to the page. */
  public final void onModuleLoad() {

    final int minRowCount = 3;
    final int maxLineCount = 2;
    // setup a text area and provide a label
    MultilineTextField areaField = new MultilineTextField("So much space !");
    // set the minimum displayed row count
    areaField.setMinRowsCount(minRowCount);
    // set the maximum input rows by the user
    areaField.setMaxLines(maxLineCount);
    // make the label float above the area on focus
    areaField.setFloat(Float.FLOAT);
    // attach the text area to the page
    get("areaContainer").add(areaField);
  }
}
