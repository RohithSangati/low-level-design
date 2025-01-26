package model;

import java.util.HashMap;
import java.util.Map;

public class BankingService {

	public Map<Long, Account> accounts;
	public Map<Long, Card> atmCards;
	private static BankingService bankingService;

	private BankingService() {
		accounts = new HashMap<>();
		atmCards = new HashMap<>();
	}

	public static BankingService getBankingServiceInstance() {
		if (bankingService == null) {
			synchronized (BankingService.class) {
				bankingService = new BankingService();
			}
		}
		return bankingService;
	}

	public long createAccount(String username, long intialBalance) {
		Account account = new Account(username, intialBalance);
		accounts.put(account.getAccountNumber(), account);
		System.out.println("Successfully created account with Account number -" + account.getAccountNumber());
		this.createAtmCard(account.getAtmCardNumber());
		return account.getAtmCardNumber();
	}

	private void createAtmCard(long atmCardNumber) {
		Card card = new Card(atmCardNumber);
		atmCards.put(atmCardNumber, card);
		System.out.println(atmCardNumber);
		System.out.println("Successfully created ATM card with Card Number - " + atmCardNumber
				+ ". Please generate pin to continue ATM services");
	}

	public Card atmCardByCardNumber(long cardNumber) {
		if (!atmCards.containsKey(cardNumber)) {
			System.out.println("The given card number is not found in our records");
		}
		return atmCards.getOrDefault(cardNumber,null);
	}

	public void credit(Account account, long amount) {
		account.creditAmount(amount);
	}

	public void debit(Account account, long amount) {
		account.debitAmount(amount);
	}

	public Account getAccountByCardNumber(long cardNumber) {
		for (Account account : accounts.values()) {
			if (account.getAtmCardNumber() == cardNumber) {
				return account;
			}
		}
		return null;
	}

}
