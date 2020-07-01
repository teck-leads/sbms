package com.techleads.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@GetMapping("/order")
	public String paymentDetails() {
		return "From Order-consumer-service";
	}

}
