package product;

public abstract class Product {

	private double price;
	private String name;

	Product(double price, String name) {
		this.price = price;
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

}
