package com.excentricdevs.presp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrEspApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrEspApplication.class, args);
	}

}
