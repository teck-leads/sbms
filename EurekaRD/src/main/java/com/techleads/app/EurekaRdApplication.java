package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EurekaRdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRdApplication.class, args);
	}

}
