package facade;

import model.Invoice;
import model.Notification;
import model.Payment;
import model.Product;

public class OrderFacade {

	public Product product;
	public Payment payment;
	public Invoice invoice;
	public Notification notification;

	public OrderFacade(Product product, Payment payment, Invoice invoice, Notification notification) {
		this.product = product;
		this.payment = payment;
		this.invoice = invoice;
		this.notification = notification;
	}

	public void placeOrder() {
		this.product.selectOrder();
		this.payment.makePayment();
		this.invoice.generateInvoice();
		this.notification.sendNotification();
		System.out.println("Order placed successfully!!!!!!!!!!!!!!");
	}

}
