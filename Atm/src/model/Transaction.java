package model;

public abstract class Transaction {

	private int transactionId;
	private Account account;
	protected BankingService bankingService;

	public Transaction(Account account) {
		this.transactionId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		this.account = account;
		this.bankingService = BankingService.getBankingServiceInstance();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public Account getAccount() {
		return account;
	}
	
	public abstract void execute(long amount);

}
