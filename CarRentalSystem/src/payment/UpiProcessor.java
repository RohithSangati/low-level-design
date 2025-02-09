package payment;

import java.util.Scanner;

public class UpiProcessor implements PaymentProcessor {

	Scanner s = new Scanner(System.in);

	@Override
	public boolean pay(double price) {
		System.out.println("Enter exact amount to be paid - "+price);
		double amount = s.nextDouble();
		if (amount == price) {
			System.out.println("Payment successfully completed!!!");
			return true;
		}
		System.out.println("Entered invalid amount");
		return false;
	}

}
