package com.rgl.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.rgl.order" })
public class OrderRestAPI {

	public static void main(String[] args) {
		SpringApplication.run(OrderRestAPI.class, args);
	}
}
