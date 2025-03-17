package shoppingcart;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CouponService {

	public static int currentPurchaseNumber;
	public static HashMap<ProductType, PriorityQueue<Integer>> nthPuchaseMap;
	public static boolean hasDiscountForNextPurchase;

	public CouponService() {

	}

	public static void initialize() {
		currentPurchaseNumber = 0;
		nthPuchaseMap = new HashMap<>();
		for (ProductType type : ProductType.values()) {
			nthPuchaseMap.put(type, new PriorityQueue<Integer>());
		}
		hasDiscountForNextPurchase = false;
	}

}
