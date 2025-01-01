package model;

public class DogRobot implements Robot {

	public String type;
	public Sprites image;

	public DogRobot(String type, Sprites image) {
		this.image = image;
		this.type = type;
	}

	public void display(int x, int y) {
		System.out.println("Dog Robot is at - " + x + " : " + y);
	}

}
