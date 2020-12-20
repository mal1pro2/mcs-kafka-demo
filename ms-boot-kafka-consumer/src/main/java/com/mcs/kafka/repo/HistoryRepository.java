package com.mcs.kafka.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mcs.kafka.document.UserInfo;

public interface HistoryRepository extends MongoRepository<UserInfo, Long> {

}
