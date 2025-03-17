package shoppingcart;

public class NextPurchaseDiscount extends CouponDecorator {

	Product product;
	int discountPercentage;

	NextPurchaseDiscount(Product product, int discountPercentage) {
		this.discountPercentage = discountPercentage;
		this.product = product;
	}

	public int getPrice() {
		if (CouponService.hasDiscountForNextPurchase) {
			return product.getPrice() - (int) ((product.getPrice() * discountPercentage) / 100.0);
		}
		return product.getPrice();
	}
	
	public ProductType getProductType() {
		return product.getProductType();
	}
}
