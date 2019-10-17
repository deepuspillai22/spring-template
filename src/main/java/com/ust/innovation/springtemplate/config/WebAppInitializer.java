package com.ust.innovation.springtemplate.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		rootContext.register(CoreConfig.class);
		//rootContext.setConfigLocation("com.ust.innovation.springtemplate.config");
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("appservices", new DispatcherServlet(rootContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/*");
		
	}
}
