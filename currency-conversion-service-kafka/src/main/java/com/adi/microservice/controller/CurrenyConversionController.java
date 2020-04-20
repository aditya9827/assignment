package com.adi.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adi.microservice.kafka.KafkaProducer;

@RestController
public class CurrenyConversionController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping(path="/sayHello")
	public String sayHelloSaga() {
		return "Hello Saga !!!";
	}
	
	@PostMapping(path = "/publish/message/{message}")
	public void sendMessage(@PathVariable String message) {
		kafkaProducer.sendHello(message);
	}

}
