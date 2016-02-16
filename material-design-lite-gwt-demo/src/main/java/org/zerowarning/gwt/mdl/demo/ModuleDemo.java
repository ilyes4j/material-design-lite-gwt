package org.zerowarning.gwt.mdl.demo;

import org.zerowarning.gwt.mdl.demo.navigation.UrlManager;

import com.google.gwt.core.client.EntryPoint;

/**
 * Stores the the relationship between a demo url and the {@link EntryPoint}
 * that should be executed to handle that url. For further explanations see
 * {@link MdlGwtDemo}.<br>
 * <br>
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 * @see MdlGwtDemo
 *
 */
public class ModuleDemo implements EntryPoint {
	public ModuleDemo() {
		super();
	}

	public ModuleDemo(String moduleUrl, EntryPoint module) {
		super();

		this.url = moduleUrl;
		this.urlParts = mgr.splitUrl(url, true);

		this.module = module;
	}

	public void setUrl(String moduleUrl) {
		this.url = moduleUrl;
		this.urlParts = mgr.splitUrl(url, true);
	}

	public void setModule(EntryPoint module) {
		this.module = module;
	}

	public boolean isIncludedIn(String inputUrl) {

		String[] inputParts = mgr.splitUrl(inputUrl, true);

		return mgr.urlInclusion(inputParts, urlParts) != -1;
	}

	@Override
	public void onModuleLoad() {
		module.onModuleLoad();
	}

	private String url;

	private String[] urlParts;

	private EntryPoint module;

	private UrlManager mgr = new UrlManager();
}
