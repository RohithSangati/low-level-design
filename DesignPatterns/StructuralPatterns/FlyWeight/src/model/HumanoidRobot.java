package model;

public class HumanoidRobot implements Robot {

	public String type;
	public Sprites image;

	public HumanoidRobot(String type, Sprites image) {
		this.image = image;
		this.type = type;
	}

	public void display(int x, int y) {
		System.out.println("Humonoid Robot is at - " + x + " : " + y);
	}

}
