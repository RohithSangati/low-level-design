import decorator.LuxuryCar;
import decorator.SportsCar;
import model.BasicCar1;
import model.BasicCar2;
import model.Car;

public class DecoratorApplication {

	public static void main(String[] args) {

		Car car1 = new LuxuryCar(new SportsCar(new BasicCar1()));
		car1.assemble();

		System.out.println("===========================");

		Car car2 = new SportsCar(new BasicCar2());
		car2.assemble();
	}

}