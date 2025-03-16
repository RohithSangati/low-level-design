package elevator;

public class InternalDispatcher {

	public void submitRequest(int floor, ElevatorCar elevator) {
		
		ElevatorController elevatorController = elevator.getElevatorController();
		elevatorController.acceptRequest(floor, elevator.getDirection(), elevator);

	}

}
