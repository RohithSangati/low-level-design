package chain;

import model.Currency;

public class DispenseChain {

	DispenseChain next;

	public DispenseChain(DispenseChain next) {
		this.next = next;
	}

	public void dispense(Currency currency) {
		if (this.next != null) {
			this.next.dispense(currency);
		}
	}

}
