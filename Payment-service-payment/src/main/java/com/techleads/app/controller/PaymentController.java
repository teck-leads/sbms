package com.techleads.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.PaymentProd;

@RestController
public class PaymentController {
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/payment")
	public String paymentDetails() {
		return "From Payment-Service-Producer: PORT-> "+port;
	}
	
	
	@GetMapping("/payobj")
	public PaymentProd paymentObj() {
		return new PaymentProd(port,"p123",new Date());
	}
	
	@GetMapping("/payobjs")
	public List<PaymentProd> paymentObjs() {
		return List.of(new PaymentProd(port,"p123",new Date()),new PaymentProd(port,"p1234",new Date()));
	}

	@GetMapping("/payment/{id}")
	public String getParam(@PathVariable("id")Integer id ) {
		return "From Payment-Service-Producer path variable is "+id+" and: PORT-> "+port;
	}
	
	@PostMapping("/payment")
	public String savePayment(@RequestBody PaymentProd paymentProd) {
		return "From Payment-Service-Producer path variable is "+paymentProd.toString()+" and: PORT-> "+port;
	}
}
