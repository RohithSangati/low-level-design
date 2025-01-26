package model;

public class DepositTransaction extends Transaction{

	public DepositTransaction(Account account) {
		super(account);
	}

	public void execute(long amount) {
		this.bankingService.credit(this.getAccount(),amount);
	}

}
