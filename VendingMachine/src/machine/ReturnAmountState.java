package machine;

import money.Coin;
import money.Note;
import product.Product;

public class ReturnAmountState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	ReturnAmountState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Product is already selected");
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Sufficient amount already added");
	}

	@Override
	public void insertNote(Note note) {
		System.out.println("Sufficient amount already added");
	}

	@Override
	public boolean dispenseProduct() {
		System.out.println("Product already dispensed");
		return false;
	}

	@Override
	public void returnAmount(boolean isProductDispensed) {
		double returnAmount = this.vendingMachine.getTotalAmount()
				- this.vendingMachine.getSelectedProduct().getPrice();
		System.out.println("Total Amount returned - " + returnAmount);
		this.vendingMachine.resetTotalAmountAndProduct();
		this.vendingMachine.setCurrentState(this.vendingMachine.getIdleState());
	}

}
