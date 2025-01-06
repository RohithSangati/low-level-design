package state;

import context.FoodOrder;

public class FoodPreparationState implements FoodOrderState{

	public void showStatus(FoodOrder foodOrder) {

		System.out.println("Food Successfully prepared");

		System.out.println("Changing to Waiting to be picked state");
		
		System.out.println("============================");
		
		foodOrder.setState(new WaitingToBePickedState());
		
	}
	
}
