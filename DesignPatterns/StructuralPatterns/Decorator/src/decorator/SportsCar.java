package decorator;

import model.Car;

public class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
	}

	public void assemble() {
		super.assemble();
		System.out.println("Added Sports car features");
	}

}
