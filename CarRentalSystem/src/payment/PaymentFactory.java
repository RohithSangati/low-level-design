package payment;

public class PaymentFactory {

	public static PaymentProcessor getPaymentProcessor(String type) {
		switch (type) {
		case "UPI":
			return new UpiProcessor();
		case "CREDITCARD":
			return new CreditCardPaymentProcessor();
		default:
			break;
		}
		return null;
	}

}
