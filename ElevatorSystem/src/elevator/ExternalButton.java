package elevator;

public class ExternalButton {

	ExternalDispatcher externalButtonDispatcher;

	public ExternalButton() {
		externalButtonDispatcher = new ExternalDispatcher();
	}

	public void pressButton(Direction direction, int currentFloorNumber) {
		this.externalButtonDispatcher.submitRequest(direction,currentFloorNumber);
	}

}
