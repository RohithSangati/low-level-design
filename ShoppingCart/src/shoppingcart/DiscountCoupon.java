package shoppingcart;

public class DiscountCoupon extends CouponDecorator {

	private int disCount;
	Product product;

	public DiscountCoupon(Product product, int disCount) {
		this.disCount = disCount;
		this.product = product;
	}

	@Override
	public int getPrice() {
		return product.getPrice() - (int) ((product.getPrice() * disCount) / 100.0);
	}
	
	public ProductType getProductType() {
		return product.getProductType();
	}

}
