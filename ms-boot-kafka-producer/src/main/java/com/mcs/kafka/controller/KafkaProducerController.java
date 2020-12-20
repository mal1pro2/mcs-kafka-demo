package com.mcs.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcs.kafka.dto.Userdto;
import com.mcs.kafka.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	@Autowired
	private KafKaProducerService producerService;

	@PostMapping(value = "/publish")
	public String sendMessageToKafkaTopic(@RequestBody Userdto dto) {
		this.producerService.sendMessage(dto);
		return "Publish successfully!";
	}

}