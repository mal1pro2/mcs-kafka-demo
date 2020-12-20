package com.mcs.viewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mcs.viewer.document.UserInfo;
import com.mcs.viewer.repo.UserRepository;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

	@Autowired
	private UserRepository repo;

	@Override
	public Page<UserInfo> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return repo.findAll(pageable);
	}

	@Override
	public List<UserInfo> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<UserInfo> findByEmail(String email, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return repo.findByEmailOrderByCreationDateTimeDesc(email, pageable);
	}

}
