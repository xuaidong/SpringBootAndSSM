package com.poineer.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MyBatisConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
		
		//数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		//基本配置文件
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        
        //别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.poineer.pojo");
        
		return sqlSessionFactoryBean;
	}
	
}
