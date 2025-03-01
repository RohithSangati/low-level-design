package model;

import java.util.HashMap;
import java.util.UUID;

public class Theatre {

	private String theatreId;
	private String name;
	private String location;
	private HashMap<String, User> administrators;

	public Theatre(String name, String location) {
		super();
		this.theatreId = UUID.randomUUID().toString();
		this.name = name;
		this.location = location;
		administrators = new HashMap<String, User>();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public User getAdministrator(String email) {
		return this.administrators.get(email);
	}

	public void addAdministrator(User user) {
		if (this.administrators.containsKey(user.getEmail())) {
			System.out.println("Administrator already added");
			return;
		}
		this.administrators.put(user.getEmail(), user);
		System.out.println("Successfully added " + user.getName() + " as admin of theatre " + this.getName());
	}

	public String getTheatreId() {
		return theatreId;
	}

	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", name=" + name + ", location=" + location + "]";
	}

}
