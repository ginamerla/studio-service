package com.marke.app.coreservice.config;

import java.util.Arrays;

import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.marke.app.coreservice.exception.ApiExceptionMapper;
import com.marke.app.coreservice.restservice.RestAdminService;
import com.marke.app.coreservice.restservice.RestInstructorService;
import com.marke.app.coreservice.utils.CustomJacksonMapperFactory;

/**
 * Configuracion de JaxRS y todos los beans a exponer como rest services.
 * @author visilva
 *
 */
@Order(2)
//This is annotated as a Configuration class for applicationContext
@Configuration
//Component scan used to locate classes in other packages
//ImportResource to include any resource files (such as .xml) in the applicationContext
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class JaxRsServerConfig {
	private static Logger LOGGER = LogManager.getLogger(JaxRsServerConfig.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	public Server jaxRsServer() {
		final Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);

		JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance()
				.createEndpoint(restCoreServiceApplication(), JAXRSServerFactoryBean.class);
		factory.setServiceBeans(Arrays.<Object> asList(
				restAdminService(),
				restInstructorService()));
		factory.setAddress(factory.getAddress());
		factory.setProviders(Arrays.<Object> asList(jsonProvider(), exceptionMapperProvider()));
		factory.setBus(bus);
		LOGGER.info("-----------------------------------------> JaxRsServer bean created.");
		return factory.create();
	}
	
	@Bean
	public RestCoreServiceApplication restCoreServiceApplication(){
		LOGGER.info("Creating GettingStartedApplication...");
		return new RestCoreServiceApplication();
	}
	

	@Bean
	public RestAdminService restAdminService(){
		LOGGER.info("RestAdmin... started!");
		return new RestAdminService();
	}
	
	/**
	 * Bean to return the Jackson JSON provider to create and parse JSON
	 * objects.
	 * 
	 * @return JacksonJsonProvider
	 */
	@Bean
	public JacksonJsonProvider jsonProvider() {
		CustomJacksonMapperFactory customMapperFactory = new CustomJacksonMapperFactory();
		return new JacksonJsonProvider(customMapperFactory.createCustomObjectMapper());
	}

	/**
	 * Bean to hold the exception mapper provider. Use to map the exceptions for
	 * this service.
	 *
	 * @return MenuDataImportApiExceptionMapper
	 */
	@Bean
	public ApiExceptionMapper exceptionMapperProvider() {
		LOGGER.debug("JasRsServerConfig : ApiExceptionMapper bean created");
		return new ApiExceptionMapper();
	}
  
	/**
	 * Agregar aqui los demas servicios Rest
	 */
	@Bean
	public RestInstructorService restInstructorService() {
		LOGGER.info("JasRsServerConfig : RestInstructorService bean created");
		return new RestInstructorService();
	}
}
