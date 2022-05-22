package com.excentricdevs.prgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrGatewayApplication.class, args);
	}

}
