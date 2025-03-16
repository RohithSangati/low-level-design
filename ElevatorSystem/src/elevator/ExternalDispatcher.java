package elevator;

import java.util.List;

public class ExternalDispatcher {

	public void submitRequest(int destination, Direction direction, int currentFloorNumber) {

		ElevatorService elevatorService = ElevatorService.getInstance();

		List<ElevatorCar> elevators = elevatorService.getElevators();

		ElevatorCar elevatorCar = null;

		// For accessing idle or on the way requests
		for (ElevatorCar eachElevatorCar : elevators) {
			if (eachElevatorCar.getState() == State.IDLE) {
				if (elevatorCar == null || (Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(eachElevatorCar.getCurrentFloor() - currentFloorNumber))) {
					elevatorCar = eachElevatorCar;
				}
			} else if (eachElevatorCar.getDirection() == Direction.UP) {
				if (direction == Direction.UP && eachElevatorCar.getCurrentFloor() <= currentFloorNumber
						&& (elevatorCar == null || (Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
								.abs(eachElevatorCar.getCurrentFloor() - currentFloorNumber)))) {
					elevatorCar = eachElevatorCar;
				}
			} else {
				if (direction == Direction.DOWN && eachElevatorCar.getCurrentFloor() >= currentFloorNumber
						&& (elevatorCar == null || (Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
								.abs(eachElevatorCar.getCurrentFloor() - currentFloorNumber)))) {
					elevatorCar = eachElevatorCar;
				}
			}
		}

		// For accessing opposite direction requests
		if (elevatorCar == null) {
			for (ElevatorCar eachElevatorCar : elevators) {
				if (eachElevatorCar.getState() == State.MOVING && eachElevatorCar.getDirection() != direction
						&& (elevatorCar == null || (Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
								.abs(eachElevatorCar.getCurrentFloor() - currentFloorNumber)))) {
					elevatorCar = eachElevatorCar;
				}
			}
		}

		// For accessing same direction requests but passed the current floor which is
		// the worst cases as it takes more time compared to others
		if (elevatorCar == null) {
			for (ElevatorCar eachElevatorCar : elevators) {
				if (eachElevatorCar.getState() == State.MOVING && eachElevatorCar.getDirection() == direction
						&& (elevatorCar == null || (Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) < Math
								.abs(eachElevatorCar.getCurrentFloor() - currentFloorNumber)))) {
					elevatorCar = eachElevatorCar;
				}
			}
		}

		ElevatorController elevatorController = elevatorCar.getElevatorController();
		elevatorController.acceptRequest(destination, direction, elevatorCar);

	}

}
