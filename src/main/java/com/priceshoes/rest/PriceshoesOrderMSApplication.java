package com.priceshoes.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Mukesh Baskaran
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.priceshoes.rest.applications"})
@ImportResource("classpath:spring-config.xml")
public class PriceshoesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PriceshoesApplication.class, args);
	}
}
