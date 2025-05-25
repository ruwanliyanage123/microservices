package com.microservices.root.orderservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class MicroservicesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrderServiceApplication.class, args);
	}

}
