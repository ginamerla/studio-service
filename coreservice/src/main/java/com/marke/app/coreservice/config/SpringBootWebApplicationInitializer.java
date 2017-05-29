package com.marke.app.coreservice.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Clase principal para arrancar con Spring boot.
 * @author visilva
 *
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
public class SpringBootWebApplicationInitializer extends SpringBootServletInitializer {

private static Logger LOGGER = LogManager.getLogger(SpringBootWebApplicationInitializer.class);
	
	public static void main(String[] args) {
		LOGGER.info("Getting Started Spring Boot Application ***************************");
		SpringApplication.run(SpringBootWebApplicationInitializer.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplicationInitializer.class);
	}
}
