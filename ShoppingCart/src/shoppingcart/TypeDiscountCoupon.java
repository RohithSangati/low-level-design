package shoppingcart;

public class TypeDiscountCoupon extends CouponDecorator {

	Product product;
	int discountPercentage;
	ProductType productType;

	public TypeDiscountCoupon(Product product, int discountPercentage, ProductType productType) {
		this.product = product;
		this.discountPercentage = discountPercentage;
		this.productType = productType;
	}

	public int getPrice() {
		if (CouponService.nthPuchaseMap.get(productType).size() != 0
				&& (CouponService.nthPuchaseMap.get(productType).peek() == CouponService.currentPurchaseNumber)) {
			return product.getPrice() - (int) ((product.getPrice() * discountPercentage) / 100.0);
		}
		return product.getPrice();
	}

	public ProductType getProductType() {
		return product.getProductType();
	}

}
