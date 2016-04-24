package com.github.ilyes4j.gwt.mdl.demo.modules.textfields;

import com.github.ilyes4j.gwt.mdl.components.ripples.Ripple;
import com.github.ilyes4j.gwt.mdl.components.textfields.Float;
import com.github.ilyes4j.gwt.mdl.components.textfields.TextField;
import com.github.ilyes4j.gwt.mdl.components.toggles.CheckBoxStyle;
import com.github.ilyes4j.gwt.mdl.components.toggles.Checkbox;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Change the text programmatically leading to the automatic relocation of the
 * label depending on the content of the textbox.
 * 
 * @author Mohamed Ilyes DIMASSI
 */
public class SetTextDemo implements EntryPoint {

  /** When the switch is pushed add/remove the text. */
  public final void onModuleLoad() {

    RootPanel root = RootPanel.get("setTextContainer");

    final Checkbox setText = new Checkbox();
    setText.setFace(CheckBoxStyle.SWITCH);
    setText.setRipple(Ripple.HAS_RIPPLE);
    setText.setWidth("auto");
    root.add(setText);

    final TextField txtfld = new TextField("Text label");
    txtfld.addStyleName(Demo.DEMO.css().inline());
    txtfld.setFloat(Float.FLOAT);
    root.add(txtfld);

    setText.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

      @Override
      public void onValueChange(final ValueChangeEvent<Boolean> event) {
        txtfld.setText(setText.getValue() ? "Text" : "");
      }
    });
  }
}
