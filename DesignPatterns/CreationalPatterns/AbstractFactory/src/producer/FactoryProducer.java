package producer;

import factory.AbstractShapeFactory;
import factory.RoundedShapeFactory;
import factory.ShapeFactory;

public class FactoryProducer {

	//Making it as a Singleton class as we don't need it to be initialized every time
	private FactoryProducer() {
	}
	
	public static AbstractShapeFactory getFactory(boolean isRounded) {
		
		if(isRounded) {
			return new RoundedShapeFactory();
		}else {
			return new ShapeFactory();
		}
		
	}

}
