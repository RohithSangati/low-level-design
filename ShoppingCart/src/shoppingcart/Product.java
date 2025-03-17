package shoppingcart;

public abstract class Product {

	protected int price;
	protected String name;
	protected ProductType productType;

	public Product() {
	}

	public Product(String name, int price, ProductType productType) {
		this.name = name;
		this.price = price;
		this.productType = productType;
	}

	public String getName() {
		return name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public abstract int getPrice();

}
