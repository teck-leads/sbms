package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private PaymentRestConsumer paymentRestConsumer;
	
	@GetMapping("/order")
	public String paymentDetails() {
		//String paymentService = restTemplate.getForObject("http://PAYMENT-SERVICE-PRODUCER/payment/", String.class,1);
		
		//return "From Order-consumer-service: Consumer ==> "+paymentService;
		return "From Order "+paymentRestConsumer.doPayFromConsumer();
	}

}
