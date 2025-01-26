package model;

import java.util.Scanner;

public class ATM {

	private final BankingService bankingService;
	private final CashDispenser cashDispenser;
	private static ATM atm;
	private Scanner sc;

	private ATM() {
		this.bankingService = BankingService.getBankingServiceInstance();
		this.cashDispenser = CashDispenser.getCashDispenser();
		sc = new Scanner(System.in);
	}

	public static ATM getAtmInstance() {
		if (atm == null) {
			synchronized (ATM.class) {
				atm = new ATM();
			}
		}
		return atm;
	}

	public void AddAmountToDispenser(long amount) {
		this.cashDispenser.addAmount(amount);
	}

	public long getAmountInDispenser() {
		return this.cashDispenser.getTotalAmount();
	}

	public void startProcessing() {
		Card card = this.authenticate();
		Transaction transaction = this.initializeTransaction(card);
		this.processTransaction(transaction);
	}

	private Card authenticate() {
		System.out.println("Please enter ATM Card Number -");
		long cardNumber = sc.nextLong();
		Card card = this.bankingService.atmCardByCardNumber(cardNumber);
		while (card == null) {
			cardNumber = sc.nextLong();
			card = this.bankingService.atmCardByCardNumber(cardNumber);
		}
		System.out.println("Please enter Pin");
		long pin = sc.nextLong();
		while (!card.validate(pin)) {
			System.out.println("Invalid pin.Please try again");
			pin = sc.nextLong();
		}
		System.out.println("Successfully Authenticated");
		return card;
	}

	private Transaction initializeTransaction(Card card) {
		System.out.println("Enter 1 to deposit money,Anything apart from 1 to withdraw money");
		int choice = sc.nextInt();
		Transaction transaction;
		Account account = this.bankingService.getAccountByCardNumber(card.getCardNumber());
		if (choice == 1) {
			transaction = new DepositTransaction(account);
		} else {
			transaction = new WithDrawlTransaction(account);
		}
		return transaction;
	}

	private void processTransaction(Transaction transaction) {
		System.out.println("Enter Amount - ");
		int amount = sc.nextInt();
		if (transaction instanceof WithDrawlTransaction) {
			if (!transaction.getAccount().isDebitable(amount)) {
				System.out.println("Insufficient balance in the account");
				return;
			}
			if (!cashDispenser.isDispensible(amount)) {
				System.out.println("Insufficient balance in the ATM Dispenser");
				return;
			}
			this.debitAmount(transaction, amount);
		} else {
			this.creditAmount(transaction, amount);
		}
		System.out.println("Process done.Thank you visit again!!!!");
	}

	private void creditAmount(Transaction transaction, int amount) {
		transaction.execute(amount);
		this.cashDispenser.addAmount(amount);
	}

	private void debitAmount(Transaction transaction, int amount) {
		transaction.execute(amount);
		this.cashDispenser.dispenseAmount(amount);
	}

}
