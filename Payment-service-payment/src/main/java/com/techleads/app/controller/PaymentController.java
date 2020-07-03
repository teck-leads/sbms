package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/payment")
	public String paymentDetails() {
		return "From Payment-Service-Producer: PORT-> "+port;
	}

}
