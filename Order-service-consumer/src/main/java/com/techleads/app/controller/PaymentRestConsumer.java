package com.techleads.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentRestConsumer {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	public String doPayFromConsumer() {
		//get instaces based on serviceId using DC
		List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE-PRODUCER");
		
		ServiceInstance serviceInstance = instances.get(0);
		//create url as URI+resource path
		URI uri = serviceInstance.getUri();
		String URI=uri+"/payment";
		//String paymentService = restTemplate.getForObject("http://PAYMENT-SERVICE-PRODUCER/payment/", String.class,1);
		
		ResponseEntity<String> forEntity = restTemplate.getForEntity(URI, String.class);
		
		String body = forEntity.getBody();
		return "(From PaymentRestConsumer + DiscoveryClient) ==> "+body;
	}

}
