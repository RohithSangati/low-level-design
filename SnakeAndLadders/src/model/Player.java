package model;

public class Player {

	private String name;
	private int currPos;
	private int id;

	public Player(String name, int currPos, int id) {
		super();
		this.name = name;
		this.currPos = currPos;
		this.id = this.generateId();
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrPos() {
		return currPos;
	}

	public void setCurrPos(int currPos) {
		this.currPos = currPos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
