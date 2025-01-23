package machine;

import java.util.HashMap;
import java.util.Map;

import product.Product;

public class Inventory {

	Map<Product, Integer> productInventor = new HashMap<>();

	public void addProduct(Product product, Integer quantity) {
		productInventor.put(product, productInventor.getOrDefault(product, 0) + quantity);
	}

	private boolean isProductAvailable(Product product) {
		return productInventor.getOrDefault(product, 0) > 0;
	}

	public synchronized boolean consumeProduct(Product product) {
		if (this.isProductAvailable(product)) {
			productInventor.put(product, productInventor.getOrDefault(product, 0) - 1);
			return true;
		}
		return false;
	}

}
