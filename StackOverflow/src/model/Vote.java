package model;

public class Vote {

	private final int value;

	private final User user;

	Vote(User user, int value) {
		this.user = user;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public User getUser() {
		return user;
	}

}
