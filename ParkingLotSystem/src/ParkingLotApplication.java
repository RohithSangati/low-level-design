import factory.VehicleFactory;
import parking.ParkingLot;
import vehicle.Vehicle;
import vehicle.VehicleType;

class ParkingLotApplication {
	public static void main(String[] args) {

		ParkingLot parkingLot = ParkingLot.getInstance();

		parkingLot.addParkingLevel(10);
		parkingLot.addParkingLevel(10);

		for (int i = 1; i <= 9; i++) {
			parkingLot.parkVehicle(VehicleFactory.getVehicle(VehicleType.BIKE, "Bike-" + i));
		}

		Vehicle bike10 = VehicleFactory.getVehicle(VehicleType.BIKE, "Bike-" + 10);
		parkingLot.parkVehicle(bike10);

		Vehicle bike11 = VehicleFactory.getVehicle(VehicleType.BIKE, "Bike-" + 11);
		parkingLot.parkVehicle(bike11);

		parkingLot.unParkVehicle(bike10);

		parkingLot.parkVehicle(bike11);

		parkingLot.unParkVehicle(bike10);

		for (int i = 1; i <= 4; i++) {
			parkingLot.parkVehicle(VehicleFactory.getVehicle(VehicleType.CAR, "Car-" + i));
		}

		for (int i = 1; i <= 10; i++) {
			parkingLot.parkVehicle(VehicleFactory.getVehicle(VehicleType.TRUCK, "Truck-" + i));
		}
		
		parkingLot.addParkingLevel(20);
		
		parkingLot.displayAvailability();

	}
}