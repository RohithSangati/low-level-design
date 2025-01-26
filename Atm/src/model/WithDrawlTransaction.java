package model;

public class WithDrawlTransaction extends Transaction {

	public WithDrawlTransaction(Account account) {
		super(account);
	}

	@Override
	public void execute(long amount) {
		this.bankingService.debit(this.getAccount(), amount);
	}

}
