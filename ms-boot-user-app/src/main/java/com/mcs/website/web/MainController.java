package com.mcs.website.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcs.website.service.UserService;

@Controller
public class MainController {

	private static String KAFKA_OVERVIEW = "Overview of Kafka";
	private static String USE_CAES_OF_KAFKA = "Use cases";
	private static String ARCHICTECTURE_OF_KAFKA = "Apache Kafka Architecture";
	private static String WHY_SO_POPULAR = "Why is kafka so Popular?";

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String root(HttpSession session) {
		service.saveHistory(KAFKA_OVERVIEW, session);
		return "index";
	}

	@GetMapping("/usecases")
	public String page1(HttpSession session) {
		service.saveHistory(USE_CAES_OF_KAFKA, session);
		return "usecases";
	}

	@GetMapping("/architecture")
	public String page2(HttpSession session) {
		service.saveHistory(ARCHICTECTURE_OF_KAFKA, session);
		return "architecture";
	}

	@GetMapping("/sopopular")
	public String page3(HttpSession session) {
		service.saveHistory(WHY_SO_POPULAR, session);
		return "sopopular";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}
}
