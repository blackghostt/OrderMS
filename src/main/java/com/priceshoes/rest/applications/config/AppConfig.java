package com.priceshoes.rest.applications.config;

import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableAsync
@EnableScheduling
@PropertySource({ "classpath:application.properties","classpath:app-${spring.profiles.active}.properties" })
public class AppConfig implements SchedulingConfigurer 
{
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
	
	@Bean(name = "dataSourceT5",destroyMethod="close")
	public DataSource getDataSource() 
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		dataSource.setMaxTotal(maximumPoolSize);
		dataSource.setMaxWaitMillis(2000);
		dataSource.setValidationQuery("select 1 from dual");
		dataSource.setTimeBetweenEvictionRunsMillis(500);
		dataSource.setLogExpiredConnections(true);
		dataSource.setMaxOpenPreparedStatements(250);
		dataSource.setRemoveAbandonedTimeout(30);
		dataSource.setLogAbandoned(true);
		
		return dataSource;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() 	{
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) 
	{
		taskRegistrar.setScheduler(poolScheduler());
	}
	
	@Bean(name="taskExecutor")
    public TaskScheduler poolScheduler() 
	{
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("taskExecutor");
        scheduler.setPoolSize(15);
        scheduler.setWaitForTasksToCompleteOnShutdown(false);
        return scheduler;
    }
	
	@Bean(name = "jobExecutor")
    public Executor threadPoolTaskExecutor() 
    {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(15);
		threadPoolTaskExecutor.setMaxPoolSize(30);
		threadPoolTaskExecutor.setThreadNamePrefix("jobExecutor");
        return threadPoolTaskExecutor;
    }
}