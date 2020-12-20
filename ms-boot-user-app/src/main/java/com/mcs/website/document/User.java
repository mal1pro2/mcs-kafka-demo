package com.mcs.website.document;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "login")
public class User {

	@Id
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	Date creationDateTime;
	private Collection<String> roles;

	public User() {

	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param creationDateTime
	 */
	public User(@NotEmpty String name, @NotEmpty @Email String email,
			@NotEmpty(message = "Please enter your password.") @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters") String password,
			Date creationDateTime) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.creationDateTime = creationDateTime;
	}

	public String getId() {
		return id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}

}
