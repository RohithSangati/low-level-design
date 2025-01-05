package strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Payment done using Credit Card. Amount = " + amount);
	}

}
