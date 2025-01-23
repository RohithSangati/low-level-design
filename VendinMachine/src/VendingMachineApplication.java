import machine.VendingMachine;
import money.Coin;
import money.Note;
import product.Coffee;
import product.Pepsi;
import product.Product;

class VendingMachineApplication {

	public static void main(String[] args) {

		VendingMachine vendingMachine = VendingMachine.getInstance();

		Product pepsi = new Pepsi(20.7);
		Product coffee = new Coffee(12.01);

		vendingMachine.addProduct(pepsi, 7);
		vendingMachine.addProduct(coffee, 1);
		
		vendingMachine.dispenseProduct();
		vendingMachine.insertCoin(Coin.NICKLE);
		vendingMachine.insertNote(Note.FIVE);
		vendingMachine.returnAmount(true);
		
		vendingMachine.selectProduct(coffee);
		
		vendingMachine.selectProduct(coffee);
		
		vendingMachine.insertCoin(Coin.QUARTER);
		vendingMachine.insertNote(Note.TEN);
		vendingMachine.insertNote(Note.FIVE);
		vendingMachine.insertNote(Note.FIVE);
		
		boolean isProductDispensed = vendingMachine.dispenseProduct();
		
		vendingMachine.dispenseProduct();
		
		vendingMachine.returnAmount(isProductDispensed);
		
		vendingMachine.selectProduct(coffee);
		vendingMachine.insertCoin(Coin.QUARTER);
		vendingMachine.insertNote(Note.TEN);
		vendingMachine.insertNote(Note.FIVE);
		
		isProductDispensed = vendingMachine.dispenseProduct();

	}

}