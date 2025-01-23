package machine;

import money.Coin;
import money.Note;
import product.Product;

public interface VendingMachineState {

	public void selectProduct(Product product);

	public void insertCoin(Coin coin);

	public void insertNote(Note note);

	public boolean dispenseProduct();

	public void returnAmount(boolean isProductDispensed);

}
