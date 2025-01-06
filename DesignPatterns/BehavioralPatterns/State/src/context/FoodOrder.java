package context;

import state.FoodOrderState;
import state.OrderInitiatedState;

public class FoodOrder {

	private FoodOrderState state;

	public FoodOrder() {
		this.state = new OrderInitiatedState();
	}

	public void setState(FoodOrderState state) {
		this.state = state;
	}

	public void getState(FoodOrderState state) {
		this.state = state;
	}

	public void showCurrentStatus() {
		this.state.showStatus(this);
	}

}
