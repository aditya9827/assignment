package com.adi.microservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "exchange", groupId = "currency-exchange-saga")
	public void consumeMessage(String message) {
		LOGGER.info(String.format("$$ -> Consumed message from Exchange Service--> %s",message));
	}

}
