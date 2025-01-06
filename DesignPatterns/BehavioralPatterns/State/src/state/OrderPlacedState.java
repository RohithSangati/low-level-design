package state;

import context.FoodOrder;

public class OrderPlacedState implements FoodOrderState {

	public void showStatus(FoodOrder foodOrder) {

		System.out.println("Order Successfully Placed");

		System.out.println("Changing to Food Preparation state");

		System.out.println("============================");

		foodOrder.setState(new FoodPreparationState());

	}

}
