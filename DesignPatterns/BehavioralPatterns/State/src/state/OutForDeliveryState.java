package state;

import context.FoodOrder;

public class OutForDeliveryState implements FoodOrderState {

	public void showStatus(FoodOrder foodOrder) {

		System.out.println("Order Out for Delivery");

		System.out.println("Changing to Delivered State");

		System.out.println("============================");

		foodOrder.setState(new DeliveredState());

	}

}
