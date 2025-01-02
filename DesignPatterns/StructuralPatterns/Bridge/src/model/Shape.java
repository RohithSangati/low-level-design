package model;

import bridge.ColourBridge;

public abstract class Shape {

	protected ColourBridge colour;

	Shape(ColourBridge colour) {
		this.colour = colour;
	}

	public abstract void applyColour();

}
