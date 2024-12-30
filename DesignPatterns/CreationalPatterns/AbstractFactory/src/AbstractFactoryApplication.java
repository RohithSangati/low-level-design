import factory.AbstractShapeFactory;
import model.Shape;
import producer.FactoryProducer;

public class AbstractFactoryApplication {

	public static void main(String[] args) {
		
		AbstractShapeFactory shapeFactory1 = FactoryProducer.getFactory(true);
		
		Shape shape1 = shapeFactory1.getShape("Rectangle");
		shape1.draw();
		
		
		Shape shape2 = shapeFactory1.getShape("Square");
		shape2.draw();
		
		AbstractShapeFactory shapeFactory2 = FactoryProducer.getFactory(false);
		
		Shape shape3 = shapeFactory2.getShape("Rectangle");
		shape3.draw();
		
		Shape shape4 = shapeFactory2.getShape("Square");
		shape4.draw();
		
	}

}