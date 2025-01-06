package state;

import context.FoodOrder;

public class WaitingToBePickedState implements FoodOrderState {

	public void showStatus(FoodOrder foodOrder) {

		System.out.println("Order Successfully Picked up");

		System.out.println("Changing to Out For Delivary State");

		System.out.println("============================");

		foodOrder.setState(new OutForDeliveryState());

	}

}
