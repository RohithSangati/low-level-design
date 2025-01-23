package machine;

import money.Coin;
import money.Note;
import product.Product;

public class DispenseState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	DispenseState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Product already selected");
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Sufficient amount already added");
	}

	@Override
	public void insertNote(Note note) {
		System.out.println("Sufficient amount alreadys added");
	}

	@Override
	public boolean dispenseProduct() {
		this.vendingMachine.setCurrentState(this.vendingMachine.getReturnAmountState());
		if (this.vendingMachine.getInventory().consumeProduct(this.vendingMachine.getSelectedProduct())) {
			System.out.println("Successfully dispensed product and chaning to return amount state");
			return true;
		}
		System.out.println("Unable to dispense product as the product is out of Stock!!!!!");
		return false;
	}

	@Override
	public void returnAmount(boolean isProductDispensed) {
		System.out.println("Product should be dispensed top retun amount");
	}

}
