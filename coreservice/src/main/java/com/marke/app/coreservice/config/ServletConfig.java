package com.marke.app.coreservice.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.ErrorPageFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta clase es un archivo de configuracion para usar Apache CXF (JaxRS).
 * Anteriormente iba en web.xml.
 * @author visilva
 *
 */
@Configuration
public class ServletConfig {
	 /**
     * Adding bean to control errorPageFilter
     * @return ErrorPageFilter
     */
    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }
    
    /**
     * Replaces the need for web.xml
     * 
     * @param context
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/*");
    }
}

