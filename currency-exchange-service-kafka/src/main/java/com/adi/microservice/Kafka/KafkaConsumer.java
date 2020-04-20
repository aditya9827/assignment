package com.adi.microservice.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	//private String message;
	
	private static String TOPIC = "exchange";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	@KafkaListener(topics = "converter", groupId = "currency-conversion-saga")
	public void consumeConversionMessage(String message) {
		LOGGER.info(String.format("$$ -> Consuming Conversion Service message --> %s",message));
		//this.message = message;
		
		publishMessage(message);
	}
	
	private void publishMessage(String message) {
		//this.message = this.message + ", How are you???";
		kafkaTemplate.send("exchange", message + ", How are you ?");
		
	}

}
