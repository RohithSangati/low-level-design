package state;

import context.FoodOrder;

public class DeliveredState implements FoodOrderState {

	public void showStatus(FoodOrder foodOrder) {
		
		System.out.println("Order Delivered");
		
		System.out.println("Order Successfully completed!!!!!!!!!!!!!!!!!");
		
	}

}
