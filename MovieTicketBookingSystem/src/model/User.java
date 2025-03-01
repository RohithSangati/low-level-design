package model;

import java.util.UUID;

public class User {

	private String userId;
	private String name;
	private String email;

	public User(String name, String email) {
		super();
		this.userId = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getUserId() {
		return userId;
	}
}
