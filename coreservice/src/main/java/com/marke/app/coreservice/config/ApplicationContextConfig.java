package com.marke.app.coreservice.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.marke.app.coreservice.dao.InstructorDao;
import com.marke.app.coreservice.dao.impl.InstructorDaoImpl;
import com.marke.app.coreservice.service.InstructorService;
import com.marke.app.coreservice.service.impl.InstructorServiceImpl;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Clase principal para la configuracion de todos los servicios y beans.
 * Aqui se declararan los DAOs, y services.
 * @author visilva
 *
 */
@Order(1)
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@Import({ JaxRsServerConfig.class })
@PropertySource({ "classpath:application.properties" })
public class ApplicationContextConfig {

private static final Logger LOG = LogManager.getLogger(ApplicationContextConfig.class);
	
	@Value("${db.url}")
    private String jdbcUrl;
    
    @Value("${db.user}")
    private String jdbcUsername;
    
    @Value("${db.password}")
    private String jdbcPassword;
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    /**
     * Bean for managing transactions and rollbacks.
     * 
     * @param dataSource
     *            the datasource (Bean) this applies to.
     * @return a PlatformTransactionManager.
     * @throws SQLException
     *             an exception from acquiring the data source.
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws SQLException {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public DataSource dataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        LOG.info("Mysql Database URL:" + jdbcUrl);
        return dataSource;
    }
    
    /**
     * Servicios y Daos
     */
    
    @Bean
	public InstructorDaoImpl instructorDao() {
		return new InstructorDaoImpl();
    }
    
    @Bean
	public InstructorServiceImpl instructorService() {
		return new InstructorServiceImpl();
    }
}
