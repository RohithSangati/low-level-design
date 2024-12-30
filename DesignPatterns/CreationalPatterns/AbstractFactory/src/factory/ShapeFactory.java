package factory;

import model.Rectangle;
import model.Shape;
import model.Square;

public class ShapeFactory implements AbstractShapeFactory {

	public Shape getShape(String type) {
		switch (type) {
		case "Rectangle":
			return new Rectangle();
		case "Square":
			return new Square();
		}
		return null;
	}

}
