package model;

import java.util.Scanner;

import chain.DispenseChain;
import chain.Rupees100Dispenser;
import chain.Rupees200Dispenser;
import chain.Rupess500Dispenser;

public class ATMDispenseChain {

	public DispenseChain dispenseChain;

	public ATMDispenseChain() {
		this.dispenseChain = new Rupess500Dispenser(new Rupees200Dispenser(new Rupees100Dispenser(null)));
	}

	public void startMachine() {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				int amount = sc.nextInt();
				if (amount % 100 == 0) {
					this.dispenseChain.dispense(new Currency(amount));
				} else {
					System.out.println("Invalid Amount.Stopping ATM!!!!!");
					return;
				}
			}
		}
	}

}
