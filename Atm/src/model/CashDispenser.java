package model;

public class CashDispenser {

	private long totalAmount;
	private static CashDispenser cashDispenser;

	private CashDispenser() {
		this.totalAmount = 0;
	}

	public static CashDispenser getCashDispenser() {
		if (cashDispenser == null) {
			synchronized (CashDispenser.class) {
				cashDispenser = new CashDispenser();
			}
		}
		return cashDispenser;
	}

	public long getTotalAmount() {
		return totalAmount;
	}
	
	public synchronized boolean isDispensible(long amount) {
		return this.totalAmount >= amount;
	}
	
	public void addAmount(long amount) {
		System.out.println("Successfully added amount to the ATM");
		this.totalAmount += amount;
	}

	public synchronized void dispenseAmount(long amount) {
		this.totalAmount -= amount;
		System.out.println("Successfully dispended amount from the ATM");
	}

}
