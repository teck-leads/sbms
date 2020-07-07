package com.techleads.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.PaymentProd;

@RestController
public class OrderController {

	@Autowired
	private PaymentRestConsumerI paymentRestConsumer;
	// private PaymentRestConsumer paymentRestConsumer;

	@GetMapping("/order")
	public String paymentDetails() {
		// String paymentService =
		// restTemplate.getForObject("http://PAYMENT-SERVICE-PRODUCER/payment/",
		// String.class,1);

		// return "From Order-consumer-service: Consumer ==> "+paymentService;
		// return "From Order "+paymentRestConsumer.doPayFromConsumer();
		return "From Order (Using Feign Client) " + paymentRestConsumer.paymentDetails();
	}

	@GetMapping("/ordpayobj")
	public String paymentObjt() {

		return "From Order (Using Feign Client) {payment object} " + paymentRestConsumer.paymentObj();
	}

	@GetMapping("/ordpayobjs")
	public String paymentObjs() {

		return "From Order (Using Feign Client) {payment objectss} " + paymentRestConsumer.paymentObjs();
	}

	@GetMapping("/ordpayparam/{id}")
	public String paymentParam(@PathVariable("id") Integer id) {

		return "From Order (Using Feign Client) {payment params} " + paymentRestConsumer.getParam(id);
	}
	
	@PostMapping("/ordpayment")
	public String savePayment(@RequestBody PaymentProd paymentProd) {
		
		paymentProd.setPid(123456);
		paymentProd.setPaymentName("PLaptop");
		paymentProd.setPaymentDate(new Date());
		return "From Payment-Service-Producer path variable is "+paymentRestConsumer.savePayment(paymentProd);
	}

}
