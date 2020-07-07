package com.techleads.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techleads.app.model.PaymentProd;

@FeignClient("PAYMENT-SERVICE-PRODUCER")
public interface PaymentRestConsumerI {
	@GetMapping("/payment")
	public String paymentDetails();

	@GetMapping("/payobj")
	public PaymentProd paymentObj();

	@GetMapping("/payobjs")
	public List<PaymentProd> paymentObjs();

	@GetMapping("/payment/{id}")
	public String getParam(@PathVariable("id") Integer id);
	@PostMapping("/payment")
	public String savePayment(@RequestBody PaymentProd paymentProd);

}
