package chain;

import model.Currency;

public class Rupees100Dispenser extends DispenseChain {

	public Rupees100Dispenser(DispenseChain next) {
		super(next);
	}

	public void dispense(Currency amount) {
		if (amount.getAmount() >= 100) {
			int numOf100Notes = amount.getAmount() / 100;
			int remainingAmount = amount.getAmount() % 100;
			System.out.println("Number of 100 notes dispensed - " + numOf100Notes);
			super.dispense(new Currency(remainingAmount));
		} else {
			super.dispense(amount);
		}
	}

}
