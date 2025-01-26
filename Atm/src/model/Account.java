package model;

public class Account {

	public long amount;
	private final long atmCardNumber;
	private final long accountNumber;
	public String userName;

	public Account(String userName, long amount) {
		this.userName = userName;
		this.amount = amount;
		this.atmCardNumber = System.currentTimeMillis();
		this.accountNumber = System.currentTimeMillis();
	}

	public void creditAmount(long amount) {
		this.amount += amount;
		System.out.println("Successfully credited amount in the Account");
	}

	public synchronized void debitAmount(long amount) {
		if (this.isDebitable(amount)) {
			this.amount -= amount;
			System.out.println("Successfully debited amount from the account");
		} else {
			System.out.print("In sufficient amount");
		}
	}

	public synchronized boolean isDebitable(long amount) {
		return this.getAmount() >= amount;
	}

	public long getAmount() {
		return amount;
	}

	public long getAtmCardNumber() {
		return atmCardNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getUserName() {
		return userName;
	}

}
