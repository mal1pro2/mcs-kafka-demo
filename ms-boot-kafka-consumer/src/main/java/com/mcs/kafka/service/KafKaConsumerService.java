package com.mcs.kafka.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mcs.kafka.common.AppConstants;
import com.mcs.kafka.document.UserInfo;
import com.mcs.kafka.repo.HistoryRepository;

@Service
public class KafKaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

	@Autowired
	private HistoryRepository repo;

	@KafkaListener(topics = AppConstants.TOPIC_NAME_USER_LOG, groupId = AppConstants.GROUP_ID)
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
		String[] str = message.split(",");
		UserInfo entity = new UserInfo(str[0], str[1], str[2], new Date());
		if (entity != null) {
			repo.save(entity);
			logger.info(String.format("Record saved into db successfully!"));
		}
	}

}
