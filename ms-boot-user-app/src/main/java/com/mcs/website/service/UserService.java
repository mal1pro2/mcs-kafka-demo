package com.mcs.website.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mcs.website.document.User;

public interface UserService extends UserDetailsService {

	public User findByEmail(String email);

	public User save(User registration);

	public String saveHistory(String tab, HttpSession session);

}
