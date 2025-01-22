package parking;

import java.util.ArrayList;
import java.util.List;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingLevel {

	private int levelIndex;
	private List<ParkingSpot> parkingSpots;

	public ParkingLevel(int numberOfSpots, int levelIndex) {
		this.parkingSpots = new ArrayList<>();
		this.levelIndex = levelIndex;
		this.allocateParkingSpots(numberOfSpots);
	}
	
	public int getLevelIndex() {
		return this.levelIndex;
	}

	private void allocateParkingSpots(int numberOfSpots) {
		// 50% Allocation For Bikes
		double numOfSpotsForBikes = (int) (0.5 * numberOfSpots);
		// 30% Allocation For Bikes
		double numOfSpotsForCars = (int) (0.3 * numberOfSpots);
		for (int i = 0; i < numberOfSpots; i++) {
			VehicleType type;
			if (i < numOfSpotsForBikes) {
				type = VehicleType.BIKE;
			} else if ((i + numOfSpotsForBikes) < numOfSpotsForCars) {
				type = VehicleType.CAR;
			} else {
				type = VehicleType.TRUCK;
			}
			this.parkingSpots.add(new ParkingSpot(type, i + 1));
		}
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (ParkingSpot parkingSpot : this.parkingSpots) {
			if (parkingSpot.parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean unParkVehicle(Vehicle vehicle) {
		for (ParkingSpot parkingSpot : this.parkingSpots) {
			if (parkingSpot.unParkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}

}
