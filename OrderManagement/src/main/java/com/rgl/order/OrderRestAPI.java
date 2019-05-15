package com.rgl.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.rgl.order"})
public class OrderRestAPI extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(OrderRestAPI.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(OrderRestAPI.class, args);
	}
}
