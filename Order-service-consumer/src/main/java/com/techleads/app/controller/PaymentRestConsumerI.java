package com.techleads.app.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PAYMENT-SERVICE-PRODUCER")
public interface PaymentRestConsumerI {
	@GetMapping("/payment")
	public String paymentDetails();

}
