/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.tck.filter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.xml.namespace.QName;


/**
 * @author  Neil Griffin
 */
public class PortletConfigTCKImpl implements PortletConfig {

	// Private Data Members
	private PortletConfig portletConfig;

	public PortletConfigTCKImpl(PortletConfig portletConfig) {
		this.portletConfig = portletConfig;
	}

	@Override
	public Map<String, String[]> getContainerRuntimeOptions() {
		return portletConfig.getContainerRuntimeOptions();
	}

	@Override
	public String getDefaultNamespace() {
		return portletConfig.getDefaultNamespace();
	}

	@Override
	public String getInitParameter(String name) {
		return portletConfig.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return portletConfig.getInitParameterNames();
	}

	@Override
	public PortletContext getPortletContext() {

		PortletContext wrappedPortletContext = portletConfig.getPortletContext();

		return new PortletContextTCKImpl(wrappedPortletContext);
	}

	@Override
	public String getPortletName() {
		return portletConfig.getPortletName();
	}

	@Override
	public Enumeration<QName> getProcessingEventQNames() {
		return portletConfig.getProcessingEventQNames();
	}

	@Override
	public Enumeration<String> getPublicRenderParameterNames() {
		return portletConfig.getPublicRenderParameterNames();
	}

	@Override
	public Enumeration<QName> getPublishingEventQNames() {
		return portletConfig.getPublishingEventQNames();
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return portletConfig.getResourceBundle(locale);
	}

	@Override
	public Enumeration<Locale> getSupportedLocales() {
		return portletConfig.getSupportedLocales();
	}
}