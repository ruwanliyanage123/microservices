package com.microservices.root.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.microservices.root.orderservice"})
public class MicroservicesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrderServiceApplication.class, args);
	}

}
