package strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Payment done using Debit Card. Amount = " + amount);
	}

}
