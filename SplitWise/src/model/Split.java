package model;

import java.util.UUID;

public abstract class Split {

	String splitId;
	double amount;
	User user;

	Split(double amout,User user) {
		this.splitId = UUID.randomUUID().toString();
		this.amount = amout;
		this.user = user;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getSplitId() {
		return splitId;
	}

	public User getUser() {
		return user;
	}

}
