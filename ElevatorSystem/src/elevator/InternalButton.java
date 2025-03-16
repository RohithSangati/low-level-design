package elevator;

public class InternalButton {

	InternalDispatcher internalButtonDispatcher;

	public InternalButton() {
		internalButtonDispatcher = new InternalDispatcher();
	}

	public void pressButton(int floor, ElevatorCar elevator) {
		this.internalButtonDispatcher.submitRequest(floor, elevator);
	}

}
