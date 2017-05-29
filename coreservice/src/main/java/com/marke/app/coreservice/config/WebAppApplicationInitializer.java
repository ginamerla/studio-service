package com.marke.app.coreservice.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Clase para declarar el Dispatcher Servlet (equivalente a web.xml)
 * @author visilva
 *
 */
public class WebAppApplicationInitializer implements WebApplicationInitializer {

private static Logger LOGGER = LogManager.getLogger(WebAppApplicationInitializer.class);
	
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext();
		servletContext.addListener(new RequestContextListener());
		LOGGER.info("Declaring Dispatcher servlet ***************************************");
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
	}
	
	/**
	 * Return spring context based on Annotation approach.
	 * @return
	 */
	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("training.spring.boot.config");
		return context;
	}
}
