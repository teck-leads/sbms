package com.techleads.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	@GetMapping("/payment")
	public String paymentDetails() {
		return "From Payment-Service-Producer";
	}

}
