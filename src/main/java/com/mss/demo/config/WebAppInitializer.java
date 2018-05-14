package com.mss.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {	//	Received and Processed by DispatcherServlet
		return new Class<?>[] { WebAppConfig.class };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {	// Received and Processed by ContextListener
		return new Class<?>[] { SpringRootConfig.class };
	}
	
	@Override
	protected String[] getServletMappings() {		//	URL mapping	
		return new String[] { "/" };
	}
}