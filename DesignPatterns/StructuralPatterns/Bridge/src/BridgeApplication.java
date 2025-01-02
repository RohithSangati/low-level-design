import bridge.GreenColour;
import bridge.RedColour;
import model.Circle;
import model.Shape;
import model.Triangle;

public class BridgeApplication {

	public static void main(String[] args) {

		Shape shape1 = new Triangle(new RedColour());
		shape1.applyColour();

		Shape shape2 = new Triangle(new GreenColour());
		shape2.applyColour();

		Shape shape3 = new Circle(new RedColour());
		shape3.applyColour();

		Shape shape4 = new Circle(new GreenColour());
		shape4.applyColour();

	}

}