package machine;

import money.Coin;
import money.Note;
import product.Product;

public class ReadyState implements VendingMachineState {

	private final VendingMachine vendingMachine;

	ReadyState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void selectProduct(Product product) {
		System.out.println("Product already selected");
	}

	@Override
	public void insertCoin(Coin coin) {
		this.vendingMachine.setTotalAmount(this.vendingMachine.getTotalAmount() + coin.getValue());
		System.out.println("Successfuly added - " + coin.getValue() + " coin");
		checkPaymentStatus();
	}

	@Override
	public void insertNote(Note note) {
		this.vendingMachine.setTotalAmount(this.vendingMachine.getTotalAmount() + note.getValue());
		System.out.println("Successfully added - " + note.getValue() + "note");
		checkPaymentStatus();
	}

	@Override
	public boolean dispenseProduct() {
		System.out.println("Insert amount to dispense product");
		return false;
	}

	@Override
	public void returnAmount(boolean isProductDispensed) {
		System.out.println("Insufficient amount to return money");
	}

	private void checkPaymentStatus() {
		if (this.vendingMachine.getTotalAmount() >= this.vendingMachine.getSelectedProduct().getPrice()) {
			System.out.println("Required amount inserted,Changing to dispensing state");
			this.vendingMachine.setCurrentState(this.vendingMachine.getDispenseState());
		}
	}

}
