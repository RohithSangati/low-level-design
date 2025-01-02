package decorator;

import model.Car;

public class CarDecorator implements Car{

	public Car carDecorator;

	public CarDecorator(Car carDecorator) {
		this.carDecorator = carDecorator;
	}

	public void assemble() {
		this.carDecorator.assemble();
	}

}
