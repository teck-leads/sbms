package com.techleads.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.techleads.app.model.PaymentProd;

@RestController
public class PaymentController {
	@Value("${server.port}")
	private int port;
	int p;
	int f;

	@GetMapping("/payment")
	@HystrixCommand(fallbackMethod = "paymentDetailsFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "2000")})
	public String paymentDetails() {
		System.out.println("paymentDetails() " + (++p));
		if (new Random().nextInt(10) <= 10) {
			throw new RuntimeException("paymentDetails is down");
		}
		return "From Payment-Service-Producer [Acutal response]: PORT-> " + port;
	}

	public String paymentDetailsFallback() {
		System.out.println("paymentDetailsFallback() " + (++f));
		return "From Payment-Service-Producer [@HystrixCommand(fallbackMethod = \"paymentDetailsFallback\")]: PORT-> "
				+ port;
	}

	@GetMapping("/payobj")
	public PaymentProd paymentObj() {
		return new PaymentProd(port, "p123", new Date());
	}

	@GetMapping("/payobjs")
	public List<PaymentProd> paymentObjs() {
		return List.of(new PaymentProd(port, "p123", new Date()), new PaymentProd(port, "p1234", new Date()));
	}

	@GetMapping("/payment/{id}")
	public String getParam(@PathVariable("id") Integer id) {
		return "From Payment-Service-Producer path variable is " + id + " and: PORT-> " + port;
	}

	@PostMapping("/payment")
	public String savePayment(@RequestBody PaymentProd paymentProd) {
		return "From Payment-Service-Producer path variable is " + paymentProd.toString() + " and: PORT-> " + port;
	}
}
