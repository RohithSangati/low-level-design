package model;

public class VehicleFactory {

	public static Vehicle getVehicle(String vehicleName) {
		switch (vehicleName) {
		case "Car":
			return new Car();
		default:
			return new NullVehicle();
		}
	}

}
