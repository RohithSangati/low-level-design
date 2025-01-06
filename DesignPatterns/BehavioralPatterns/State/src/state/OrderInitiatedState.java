package state;

import context.FoodOrder;

public class OrderInitiatedState implements FoodOrderState {

	public void showStatus(FoodOrder foodOrder) {

		System.out.println("Order Successfully Initiated");

		System.out.println("Changing to Order Placing State");

		System.out.println("============================");

		foodOrder.setState(new OrderPlacedState());

	}

}
