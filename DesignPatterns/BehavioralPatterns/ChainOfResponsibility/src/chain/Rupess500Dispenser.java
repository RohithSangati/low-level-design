package chain;

import model.Currency;

public class Rupess500Dispenser extends DispenseChain {

	public Rupess500Dispenser(DispenseChain next) {
		super(next);
	}

	public void dispense(Currency amount) {
		if (amount.getAmount() >= 500) {
			int numOf500Notes = amount.getAmount()/500;
			int remainingAmount = amount.getAmount()%500;
			System.out.println("Number of 500 notes dispensed - "+ numOf500Notes);
			super.dispense(new Currency(remainingAmount));
		}else {
			super.dispense(amount);
		}
	}

}
