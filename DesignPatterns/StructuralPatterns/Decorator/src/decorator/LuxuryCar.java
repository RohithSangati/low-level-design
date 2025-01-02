package decorator;

import model.Car;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	public void assemble() {
		super.assemble();
		System.out.println("Added Luxury car features");
	}

}
