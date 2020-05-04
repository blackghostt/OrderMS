package com.priceshoes.rest.applications.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource({ "classpath:application.properties","classpath:hikari.properties" })
public class AppConfig {
	@Value("${server.contextPath}")
	private String context;
	
	@Value("${jdbcUrl}") private String jdbcUrl;
	@Value("${username}") private String username;
	@Value("${password}") private String password;
	@Value("${maximumPoolSize}") private Integer maximumPoolSize;
	@Value("${dataSourceClassName}") private String dataSourceClassName;
	@Value("${hibernate.show_sql}") private Boolean showSql;
	@Value("${price.sucursal}") private Integer priceSucursal;
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryLocal() 
	{
		Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.hbm2dll.auto", "validate");
        properties.put("hibernate.show_sql", showSql);
        properties.put("current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");
        
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.priceshoes.rest" });
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	@Bean(name = "dataSource-T98")
	public HikariDataSource getDataSource()	
	{
		final HikariDataSource ds = new HikariDataSource();
		ds.setDataSourceClassName(dataSourceClassName);
		ds.setMaximumPoolSize(maximumPoolSize);
		ds.addDataSourceProperty("url",jdbcUrl);
		ds.addDataSourceProperty("user",username);
		ds.addDataSourceProperty("password",password);
		ds.setPoolName("restPoolHikari-T"+priceSucursal);
		return ds;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}