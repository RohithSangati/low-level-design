import java.util.HashMap;

import shoppingcart.CouponService;
import shoppingcart.Item1;
import shoppingcart.Product;
import shoppingcart.ProductType;
import shoppingcart.ShoppingCart;

public class ShoppingCartApplication {
	public static void main(String[] args) {
		
		CouponService.initialize();

		Product item1 = new Item1("Bat", 1000, ProductType.SPORTS);
		Product item2 = new Item1("Ball", 2000, ProductType.SPORTS);

		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(item1);
		cart.addToCart(item2);

		System.out.println(cart.getPrice());

		HashMap<ProductType, Integer> mp = new HashMap<>();
		mp.put(ProductType.SPORTS, 2);
		cart.pay(true, mp);

		System.out.println(CouponService.currentPurchaseNumber);
		System.out.println(CouponService.hasDiscountForNextPurchase);
		System.out.println(CouponService.nthPuchaseMap);

		System.out.println("==========================================");

		Product item11 = new Item1("Bat", 1000, ProductType.SPORTS);
		Product item12 = new Item1("Ball", 2000, ProductType.SPORTS);

		ShoppingCart cart1 = new ShoppingCart();
		cart1.addToCart(item11);
		cart1.addToCart(item12);

		System.out.println(cart1.getPrice());

		cart1.pay(true, null);

		System.out.println(CouponService.currentPurchaseNumber);
		System.out.println(CouponService.hasDiscountForNextPurchase);
		System.out.println(CouponService.nthPuchaseMap);

	}
}