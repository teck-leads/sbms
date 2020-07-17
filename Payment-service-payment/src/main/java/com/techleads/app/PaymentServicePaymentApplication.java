package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@RefreshScope
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class PaymentServicePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServicePaymentApplication.class, args);
	}

}
