package factory;

import model.Shape;

public interface AbstractShapeFactory {

	Shape getShape(String type);

}
