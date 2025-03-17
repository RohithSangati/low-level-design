package shoppingcart;

public class Item2 extends Product {

	public Item2(String name, int price, ProductType type) {
		super(name, price, type);
	}

	@Override
	public int getPrice() {
		return this.price;
	}

}
