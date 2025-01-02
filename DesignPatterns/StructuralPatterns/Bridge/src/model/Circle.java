package model;

import bridge.ColourBridge;

public class Circle extends Shape {

	public Circle(ColourBridge colour) {
		super(colour);
	}

	public void applyColour() {
		this.colour.applyColour("Circle");
	}

}
