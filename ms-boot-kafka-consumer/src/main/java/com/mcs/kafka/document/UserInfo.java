package com.mcs.kafka.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "history")
public class UserInfo {

	@Id
	private String id;
	private String name;
	private String email;
	private String tab;
	Date creationDateTime;

	public String getId() {
		return id;
	}

	public UserInfo(String name, String email, String tab, Date creationDateTime) {
		this.name = name;
		this.email = email;
		this.tab = tab;
		this.creationDateTime = creationDateTime;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

}
