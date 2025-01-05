import model.PaymentProcessor;
import strategy.CreditCardPaymentStrategy;
import strategy.DebitCardPaymentStrategy;
import strategy.UpiPaymentStrategy;

public class StrategyApplication {

	public static void main(String[] args) {

		PaymentProcessor paymentProcessor1 = new PaymentProcessor(new CreditCardPaymentStrategy());

		paymentProcessor1.pay(200);
		paymentProcessor1.pay(500);

		PaymentProcessor paymentProcessor2 = new PaymentProcessor(new DebitCardPaymentStrategy());

		paymentProcessor2.pay(2000);
		paymentProcessor2.pay(5000);

		PaymentProcessor paymentProcessor3 = new PaymentProcessor(new UpiPaymentStrategy());

		paymentProcessor3.pay(20000);
		paymentProcessor3.pay(50000);

	}

}