package chain;

import model.Currency;

public class Rupees200Dispenser extends DispenseChain {

	public Rupees200Dispenser(DispenseChain next) {
		super(next);
	}

	public void dispense(Currency amount) {
		if (amount.getAmount() >= 200) {
			int numOf200Notes = amount.getAmount() / 200;
			int remainingAmount = amount.getAmount() % 200;
			System.out.println("Number of 200 notes dispensed - " + numOf200Notes);
			super.dispense(new Currency(remainingAmount));
		} else {
			super.dispense(amount);
		}
	}

}
