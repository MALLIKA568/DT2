package com.niit.Collobaration.config;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	protected Class<?>[] getRootConfigClasses() {

		return new Class[]{WebResolver.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}
}
