package factory;

import vehicle.Bike;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class VehicleFactory {

	public static Vehicle getVehicle(VehicleType type, String vehicleNumber) {
		switch (type) {
		case VehicleType.BIKE:
			return new Bike(vehicleNumber);
		case VehicleType.CAR:
			return new Car(vehicleNumber);
		case VehicleType.TRUCK:
			return new Truck(vehicleNumber);
		default:
			return null;
		}
	}

}
