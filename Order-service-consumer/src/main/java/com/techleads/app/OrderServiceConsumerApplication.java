package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients //entable generating proxy clases
@EnableEurekaClient // register with Eureka
@SpringBootApplication
public class OrderServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceConsumerApplication.class, args);
	}

}
