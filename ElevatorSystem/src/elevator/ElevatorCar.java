package elevator;

import java.util.UUID;

public class ElevatorCar {

	private String id;
	private int currentFloor;
	private Direction direction;
	private State state;
	private Display display;
	private InternalButton internalButtons;
	private ElevatorController elevatorController;

	public ElevatorCar() {
		id = UUID.randomUUID().toString();
		currentFloor = 0;
		state = State.IDLE;
		direction = Direction.UP;
		display = new Display(this.currentFloor, this.direction);
		internalButtons = new InternalButton();
		elevatorController = new ElevatorController();
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Display getDisplay() {
		return display;
	}

	public InternalButton getInternalButtons() {
		return internalButtons;
	}

	public ElevatorController getElevatorController() {
		return elevatorController;
	}

	public String getId() {
		return id;
	}

}
