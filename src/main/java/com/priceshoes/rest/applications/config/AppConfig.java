package com.priceshoes.rest.applications.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class AppConfig {
	@Value("${server.contextPath}")
	private String context;
}