package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSpot {

	private int spotNumber;
	private Vehicle occupiedVehicle;
	private VehicleType type;

	public ParkingSpot(VehicleType type, int spotNumber) {
		this.type = type;
		this.spotNumber = spotNumber;
	}

	public boolean isAvailable() {
		return occupiedVehicle == null;
	}

	public synchronized boolean parkVehicle(Vehicle vehicle) {
		if (this.isAvailable() && vehicle.getType() == this.type) {
			this.occupiedVehicle = vehicle;
			return true;
		}
		return false;
	}

	public synchronized boolean unParkVehicle(Vehicle vehicle) {
		if (this.occupiedVehicle == vehicle) {
			this.occupiedVehicle = null;
			return true;
		}
		return false;
	}

	public void displayAvailability() {
		String status = this.isAvailable() ? "Available" : "Occupied";
		System.out.println(
				"Parking Spot Number - " + this.spotNumber + " : Type - " + this.type + " : Status - " + status);
	}

}
