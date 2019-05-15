package com.rgl.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.rgl.order" })
@EnableDiscoveryClient
@EnableFeignClients
public class OrderRestAPI {

	public static void main(String[] args) {
		SpringApplication.run(OrderRestAPI.class, args);
	}
}
