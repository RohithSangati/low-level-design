package factory;

import model.RoundedRectangle;
import model.RoundedSquare;
import model.Shape;

public class RoundedShapeFactory implements AbstractShapeFactory {

	public Shape getShape(String type) {
		switch (type) {
			case "Rectangle":
				return new RoundedRectangle();
			case "Square":
				return new RoundedSquare();
		}
		return null;
	}

}