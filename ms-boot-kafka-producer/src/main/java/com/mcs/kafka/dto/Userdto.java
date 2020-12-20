package com.mcs.kafka.dto;

public class Userdto {

	private String name;
	private String email;
	private String tab;

	public Userdto(String name, String email, String tab) {
		this.name = name;
		this.email = email;
		this.tab = tab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

}
