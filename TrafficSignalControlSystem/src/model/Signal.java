package model;

public enum Signal {
	RED("red"), YELLOW("yellow"), GREEN("green");

	private String value;

	Signal(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
