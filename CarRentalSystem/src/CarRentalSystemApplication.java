import java.util.Date;
import java.util.List;

import rental.Car;
import rental.CarType;
import rental.Customer;
import rental.RentalSystem;

class CarRentalSystemApplication {

	public static void main(String[] args) {

		RentalSystem rentalSystem = RentalSystem.getRentalSystem();

		Customer customer1 = new Customer("Rohith", "MSPD", "LicenceDetails1");
		Customer customer2 = new Customer("Moulika", "TDND", "LicenceDetails2");

		Car car1 = new Car("Toyota", CarType.SEDAN, 1880, "AP03BE1925", 250);
		Car car2 = new Car("BMW", CarType.LUXURY, 1832, "AP03BR1990", 300);

		rentalSystem.addCustomer(customer1);
		rentalSystem.addCustomer(customer2);

		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);

		List<Car> availableCars = rentalSystem.findCar("Toyota", CarType.SEDAN, 100, 300, new Date(2025, 2, 8),
				new Date(2025, 2, 8));

		for (Car car : availableCars) {
			System.out.println(car.toString());
		}

		Car bookableCar = availableCars.get(0);

		int reservationId = rentalSystem.bookCar(bookableCar, new Date(2025, 2, 8), new Date(2025, 2, 8), customer1);

		rentalSystem.cancelReservation(rentalSystem.getReservationById(reservationId));

		availableCars = rentalSystem.findCar("Toyota", CarType.SEDAN, 100, 300, new Date(2025, 2, 8),
				new Date(2025, 2, 8));

		for (Car car : availableCars) {
			System.out.println(car.toString());
		}

	}

}