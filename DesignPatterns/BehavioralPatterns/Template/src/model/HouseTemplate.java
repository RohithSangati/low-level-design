package model;

public abstract class HouseTemplate {

	public final void buildHouse() {
		this.buildBase();
		this.buildPillars();
		this.buildWalls();
		this.buildWindows();
		System.out.println("House built successfully!!!");
	}

	public void buildBase() {
		System.out.println("Added base with Concrete,Peables,Iron rods and Sand");
	}

	public abstract void buildWindows();

	public abstract void buildWalls();

	public abstract void buildPillars();

}
