package elevator;

public class Floor {

	private int floorNumber;
	private ExternalButton externalButton;

	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
		this.externalButton = new ExternalButton();
	}

	public ExternalButton getExternalButton() {
		return externalButton;
	}

	public void pressButton(Direction direction) {
		externalButton.pressButton(direction,floorNumber);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

}
