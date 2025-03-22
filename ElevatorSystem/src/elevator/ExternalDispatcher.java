package elevator;

import java.util.List;

public class ExternalDispatcher {

	public void submitRequest(Direction direction, int currentFloorNumber) {

		ElevatorService elevatorService = ElevatorService.getInstance();

		List<ElevatorCar> elevators = elevatorService.getElevators();

		ElevatorCar elevatorCar = null;

		for (ElevatorCar car : elevators) {
			if (car.getState() == State.IDLE) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}

		if (elevatorCar == null) {
			if (direction == Direction.UP) {
				elevatorCar = getSuitableCarForUP(elevators, currentFloorNumber);
			} else {
				elevatorCar = getSuitableCarForDown(elevators, currentFloorNumber);
			}
		}

		ElevatorController elevatorController = elevatorCar.getElevatorController();
		elevatorController.acceptRequest(currentFloorNumber, direction, elevatorCar);

	}

	private ElevatorCar getSuitableCarForDown(List<ElevatorCar> elevators, int currentFloorNumber) {
		ElevatorCar elevatorCar = null;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.DOWN
					&& car.getCurrentFloor() > currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.UP
					&& car.getCurrentFloor() > currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) < Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.UP
					&& car.getCurrentFloor() < currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.DOWN
					&& car.getCurrentFloor() < currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) < Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		return elevatorCar;
	}

	private ElevatorCar getSuitableCarForUP(List<ElevatorCar> elevators, int currentFloorNumber) {
		ElevatorCar elevatorCar = null;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.UP
					&& car.getCurrentFloor() < currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.DOWN
					&& car.getCurrentFloor() < currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) < Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.DOWN
					&& car.getCurrentFloor() > currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) > Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		if (elevatorCar != null)
			return elevatorCar;
		for (ElevatorCar car : elevators) {
			if (car.getState() != State.IDLE && car.getDirection() == Direction.UP
					&& car.getCurrentFloor() > currentFloorNumber) {
				if (elevatorCar == null || Math.abs(elevatorCar.getCurrentFloor() - currentFloorNumber) < Math
						.abs(car.getCurrentFloor() - currentFloorNumber)) {
					elevatorCar = car;
				}
			}
		}
		return elevatorCar;
	}

}
