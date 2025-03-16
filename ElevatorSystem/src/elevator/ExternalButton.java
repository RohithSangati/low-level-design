package elevator;

public class ExternalButton {

	ExternalDispatcher externalButtonDispatcher;

	public ExternalButton() {
		externalButtonDispatcher = new ExternalDispatcher();
	}

	public void pressButton(int floor, Direction direction, int currentFloorNumber) {
		this.externalButtonDispatcher.submitRequest(floor, direction,currentFloorNumber);
	}

}
