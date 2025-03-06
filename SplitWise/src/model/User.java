package model;

import java.util.HashMap;
import java.util.UUID;

public class User {

	private String userId;
	private String name;
	private String email;
	private HashMap<String, Double> amountSheet;

	public User(String name, String email) {
		super();
		this.userId = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.amountSheet = new HashMap<>();
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setAmountSheet(String balanceKey, double amount) {
		amountSheet.put(balanceKey, amount);
	}

	public HashMap<String, Double> getAmountSheet() {
		return amountSheet;
	}
	
	

}
