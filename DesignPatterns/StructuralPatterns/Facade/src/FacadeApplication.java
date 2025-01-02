import facade.OrderFacade;
import model.Invoice;
import model.Notification;
import model.Payment;
import model.Product;

public class FacadeApplication {

	public static void main(String[] args) {

		OrderFacade order = new OrderFacade(new Product(), new Payment(), new Invoice(), new Notification());
		order.placeOrder();

	}

}