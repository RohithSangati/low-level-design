package strategy;

public class UpiPaymentStrategy implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Payment done using UPI. Amount = " + amount);
	}
	
}
