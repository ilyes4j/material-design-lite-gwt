package org.zerowarning.gwt.mdl.demo.navigation.components;

import static com.google.gwt.user.client.Window.Location.assign;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createMiniFab;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonFabColor.COLORED;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;

import org.zerowarning.gwt.mdl.components.buttons.Button;
import org.zerowarning.gwt.mdl.demo.navigation.INavigationItem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A {@link ComponentsItem} is a link the demo page of a gwt-mdl component. It
 * is intended to be placed inside a {@link ComponentsBar}.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class ComponentsItem extends Composite implements INavigationItem {

	/**
	 * Setup a navigation item that will be placed inside the components
	 * navigation bar.
	 */
	public ComponentsItem(String icon) {

		// setup the component icon
		btn = createMiniFab(COLORED, HAS_RIPPLE, icon);

		// setup a container for the icon
		btnContainer = new FlowPanel();
		btnContainer.setStyleName("demo-compsbar-item-icon");
		// put the icon inside its container
		btnContainer.add(btn);

		// setup a container for the link caption
		captionContainer = new FlowPanel();
		captionContainer.setStyleName("demo-text");

		container = new FlowPanel();
		container.setStyleName("demo-compsbar-item");

		// put the icon container inside the link container
		container.add(btnContainer);
		// put the caption container after the icon
		container.add(captionContainer);

		// initialize the link component
		initWidget(container);
	}

	@Override
	public void setActive(boolean active) {
		btn.setEnabled(active);
		container.setStyleDependentName("active", !active);
		if (active) {
			container.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					assign(url);
				}
			}, ClickEvent.getType());
		}
	}

	/**
	 * Sets the text that should be displayed besides the icon
	 * 
	 * @param caption
	 */
	public void setCaption(String caption) {
		captionContainer.getElement().setInnerText(caption);
	}

	@Override
	public void setUrl(String inputurl) {
		this.url = inputurl;
	}

	@Override
	public String getUrl() {
		return this.url;
	}

	private String url;

	private FlowPanel captionContainer;

	private Button btn;

	private FlowPanel container;

	private FlowPanel btnContainer;
}
