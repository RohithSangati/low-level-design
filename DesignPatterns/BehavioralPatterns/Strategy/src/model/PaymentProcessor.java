package model;

import strategy.PaymentStrategy;

public class PaymentProcessor {

	PaymentStrategy paymentStrategy;

	public PaymentProcessor(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void pay(int amount) {
		this.paymentStrategy.pay(amount);
	}

}
