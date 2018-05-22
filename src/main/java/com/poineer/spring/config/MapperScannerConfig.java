package com.poineer.spring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		
		MapperScannerConfigurer mapperScannerConfigurer =new MapperScannerConfigurer();
	    
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		
		mapperScannerConfigurer.setBasePackage("com.poineer.mapper");
		
		return mapperScannerConfigurer;
	}

}
