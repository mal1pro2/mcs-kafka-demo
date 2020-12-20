package com.mcs.website.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcs.website.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	public User findByEmail(String email);

}