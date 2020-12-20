package com.mcs.viewer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mcs.viewer.document.UserInfo;

public interface UserHistoryService {

	public Page<UserInfo> findPaginated(int pageNo, int pageSize);

	public List<UserInfo> findAll();

	public Page<UserInfo> findByEmail(String email, int pageNo, int pageSize);
}
