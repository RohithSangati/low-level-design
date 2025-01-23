package machine;

import money.Coin;
import money.Note;
import product.Product;

public class VendingMachine {

	private Product selectedProduct;
	private double totalAmount;
	private VendingMachineState currentState;

	private final VendingMachineState idleState;
	private final VendingMachineState readyState;
	private final VendingMachineState dispenseState;
	private final VendingMachineState returnAmountState;

	private Inventory inventory;

	private static VendingMachine vendingMachineInstance;

	private VendingMachine() {
		this.selectedProduct = null;
		this.totalAmount = 0;
		this.inventory = new Inventory();
		this.idleState = new IdleState(this);
		this.readyState = new ReadyState(this);
		this.dispenseState = new DispenseState(this);
		this.returnAmountState = new ReturnAmountState(this);
		this.setCurrentState(this.getIdleState());
	}

	public static VendingMachine getInstance() {
		if (vendingMachineInstance == null) {
			synchronized (VendingMachine.class) {
				vendingMachineInstance = new VendingMachine();
			}
		}
		return vendingMachineInstance;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public VendingMachineState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(VendingMachineState currentState) {
		this.currentState = currentState;
	}

	public VendingMachineState getIdleState() {
		return idleState;
	}

	public VendingMachineState getReadyState() {
		return readyState;
	}

	public VendingMachineState getDispenseState() {
		return dispenseState;
	}

	public VendingMachineState getReturnAmountState() {
		return returnAmountState;
	}

	public void selectProduct(Product product) {
		this.currentState.selectProduct(product);
	}

	public void insertCoin(Coin coin) {
		this.currentState.insertCoin(coin);
	}

	public void insertNote(Note note) {
		this.currentState.insertNote(note);
	}

	public boolean dispenseProduct() {
		return this.currentState.dispenseProduct();
	}

	public void returnAmount(boolean isProductDispensed) {
		this.currentState.returnAmount(isProductDispensed);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void resetTotalAmountAndProduct() {
		this.selectedProduct = null;
		this.totalAmount = 0;
	}

	public void addProduct(Product product, int quantity) {
		this.inventory.addProduct(product, quantity);
	}

}
