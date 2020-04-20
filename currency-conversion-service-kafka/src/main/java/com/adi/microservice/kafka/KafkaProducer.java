package com.adi.microservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	private static final String TOPIC = "converter";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendHello(String message) {
		logger.info(String.format("$$ -> Producing message --> %s",message));
		kafkaTemplate.send(TOPIC, message);
	}
	
	

}
