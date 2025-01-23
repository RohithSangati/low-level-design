package machine;

import money.Coin;
import money.Note;
import product.Product;

public class IdleState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	IdleState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void selectProduct(Product product) {
		this.vendingMachine.setSelectedProduct(product);
		System.out.println("Selected -" + product.getName() + " and please insert amount of Rupees - "
				+ product.getPrice() + " to dispense");
		this.vendingMachine.setCurrentState(this.vendingMachine.getReadyState());
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Please select product to insert coin");
	}

	@Override
	public void insertNote(Note note) {
		System.out.println("Please select product to insert note");
	}

	@Override
	public boolean dispenseProduct() {
		System.out.println("No product selected to dispense");
		return false;
	}

	@Override
	public void returnAmount(boolean isProductDispensed) {
		System.out.println("No product selected to return amount");
	}

}
