package com.mcs.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mcs.kafka.common.AppConstants;
import com.mcs.kafka.dto.Userdto;

@Service
public class KafKaProducerService {
	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(Userdto dto) {
		logger.info(String.format("Message sent -> %s", dto.getName() + "-" + dto.getEmail()));
		String message = dto.getName() + "," + dto.getEmail() + "," + dto.getTab();
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME_USER_LOG, message);
	}

}
