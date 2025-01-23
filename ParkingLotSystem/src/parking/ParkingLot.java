package parking;

import java.util.ArrayList;
import java.util.List;

import vehicle.Vehicle;

public class ParkingLot {

	private List<ParkingLevel> levels;

	private static ParkingLot parkingLotInstance;

	private ParkingLot() {
		this.levels = new ArrayList<>();
	}

	public static ParkingLot getInstance() {
		if (parkingLotInstance == null) {
			synchronized (ParkingLot.class) {
				parkingLotInstance = new ParkingLot();
			}
		}
		return parkingLotInstance;
	}

	public void addParkingLevel(int numberOfSpots) {
		ParkingLevel level = new ParkingLevel(numberOfSpots, this.levels.size() + 1);
		levels.add(level);
		System.out.println("Level " + this.levels.size() + " added to parkinglot");
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (ParkingLevel level : levels) {
			if (level.parkVehicle(vehicle)) {
				System.out.println(
						"Vehicle with vehicle number - " + vehicle.getVehicleNumber() + " is successfully parked");
				return true;
			}
		}
		System.out.println("Vehicle with vehicle number - " + vehicle.getVehicleNumber()
				+ " is not parked as space is fully occupied");
		return false;
	}

	public boolean unParkVehicle(Vehicle vehicle) {
		for (ParkingLevel level : levels) {
			if (level.unParkVehicle(vehicle)) {
				System.out.println(
						"Vehicle with vehicle number - " + vehicle.getVehicleNumber() + " is successfully unparked");
				return true;
			}
		}
		System.out.println("Vehicle with vehicle number - " + vehicle.getVehicleNumber()
				+ " is not unparked as vehicle is not parked");
		return false;
	}

	public void displayAvailability() {
		for(ParkingLevel level : levels) {
			level.displayAvailability();
		}
	}

}
