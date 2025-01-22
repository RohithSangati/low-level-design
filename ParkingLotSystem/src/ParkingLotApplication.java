import factory.VehicleFactory;
import parking.ParkingLot;
import vehicle.Vehicle;
import vehicle.VehicleType;

class ParkingLotApplication {
	public static void main(String[] args) {

		ParkingLot parkingLot = ParkingLot.getInstance();

		parkingLot.addParkingLevel(10);
		parkingLot.addParkingLevel(10);

		Vehicle vehicle;
		for (int i = 1; i <= 11; i++) {
			vehicle = VehicleFactory.getVehicle(VehicleType.BIKE, "Bike-" + i);
			parkingLot.parkVehicle(vehicle);
		}
	}
}