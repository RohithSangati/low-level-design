package shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {

	List<Product> products;

	public ShoppingCart() {
		products = new ArrayList<>();
	}

	public void addToCart(Product product) {
		Product couponedProduct = new TypeDiscountCoupon(new NextPurchaseDiscount(new DiscountCoupon(product, 10), 10),
				10, ProductType.SPORTS);
		products.add(couponedProduct);
	}

	public int getPrice() {
		int totalPrice = 0;
		for (Product product : products) {
			System.out.println(product.getPrice());
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}

	public void pay(boolean hasDiscountForNextPurchase, HashMap<ProductType, Integer> nthPuchaseOffer) {
		// For making choice for the nextPurchase to have discount or not
		CouponService.hasDiscountForNextPurchase = hasDiscountForNextPurchase;

		// Updating nth purchasing discount as its applied
		for (Product product : products) {
			while (CouponService.nthPuchaseMap != null
					&& CouponService.nthPuchaseMap.get(product.getProductType()).size() != 0
					&& (CouponService.nthPuchaseMap.get(product.getProductType())
							.peek() == CouponService.currentPurchaseNumber)) {
				CouponService.nthPuchaseMap.get(product.getProductType()).poll();
			}
		}

		// For adding nth purchase Offer
		if (nthPuchaseOffer != null) {
			for (ProductType type : nthPuchaseOffer.keySet()) {
				CouponService.nthPuchaseMap.get(type)
						.add(CouponService.currentPurchaseNumber + nthPuchaseOffer.get(type) - 1);
			}
		}
		CouponService.currentPurchaseNumber++;
	}

}
