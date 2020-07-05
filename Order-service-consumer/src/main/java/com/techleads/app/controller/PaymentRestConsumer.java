package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*@Component commented because we are using Feign client
public class PaymentRestConsumer {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	
	public String doPayFromConsumer() {
		//select one instance from Eureka Loadbancer Register with has less load
		ServiceInstance si = loadBalancerClient.choose("PAYMENT-SERVICE-PRODUCER");
		//read URI and add Resouce path =URL
		String URI=si.getUri()+"/payment";
		//String paymentService = restTemplate.getForObject("http://PAYMENT-SERVICE-PRODUCER/payment/", String.class,1);
		//make GET request call to payment service
		ResponseEntity<String> forEntity = restTemplate.getForEntity(URI, String.class);
		
		String body = forEntity.getBody();
		return "(From PaymentRestConsumer + with LoadBalancerClient) ==> "+body;
	}

}*/
