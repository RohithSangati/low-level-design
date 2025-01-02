package model;

import bridge.ColourBridge;

public class Triangle extends Shape {

	public Triangle(ColourBridge colour) {
		super(colour);
	}

	public void applyColour() {
		this.colour.applyColour("Traingle");
	}

}
