package com.mcs.viewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcs.viewer.document.UserInfo;
import com.mcs.viewer.service.UserHistoryService;

@Controller
public class UserController {

	@Autowired
	private UserHistoryService userHistoryService;

	private int pageSize = 10;
	private int firstPage = 1;

	@RequestMapping("/")
	public String fetchAllHistory(Model model) {
		List<UserInfo> listHistory = userHistoryService.findAll();
		model.addAttribute("listHistory", listHistory);
		return "index";
	}

	@RequestMapping("/history/page/{pageNo}")
	public String fetchAllHistory(@PathVariable(value = "pageNo") int pageNo, Model model) {

		Page<UserInfo> page = userHistoryService.findPaginated(pageNo, pageSize);
		List<UserInfo> listHistory = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listHistory", listHistory);

		return "index";
	}

	@RequestMapping("/history/page/{email}/{pageNo}")
	public String fetchAllHistory(@PathVariable(value = "email") String email,
			@PathVariable(value = "pageNo") int pageNo, Model model) {

		Page<UserInfo> page = userHistoryService.findByEmail(email, pageNo, pageSize);
		List<UserInfo> listHistory = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listHistory", listHistory);

		return "index";
	}
}
