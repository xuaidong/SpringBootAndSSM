package com.poineer.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties", "classpath:env.properties",
"classpath:httpclient.properties" })
@ComponentScan(basePackages="com.poineer")
@SpringBootApplication
public class TaotaoApplication extends SpringBootServletInitializer{

	    @Value("${jdbc.url}")
	    private String jdbcUrl;

	    @Value("${jdbc.driverClassName}")
	    private String jdbcDriverClassName;

	    @Value("${jdbc.username}")
	    private String jdbcUsername;

	    @Value("${jdbc.password}")
	    private String jdbcPassword;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource(){
		 BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
	        boneCPDataSource.setDriverClass(jdbcDriverClassName);
	        boneCPDataSource.setJdbcUrl(jdbcUrl);
	        boneCPDataSource.setUsername(jdbcUsername);
	        boneCPDataSource.setPassword(jdbcPassword);
	        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
	        boneCPDataSource.setIdleMaxAgeInMinutes(30);
	        boneCPDataSource.setMaxConnectionsPerPartition(100);
	        boneCPDataSource.setMinConnectionsPerPartition(5);
	        return boneCPDataSource;
	}
	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(TaotaoApplication.class);
	}
}
