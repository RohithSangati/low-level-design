package shoppingcart;

public class Item1 extends Product {

	public Item1(String name, int price, ProductType type) {
		super(name, price, type);
	}

	@Override
	public int getPrice() {
		return this.price;
	}

}
