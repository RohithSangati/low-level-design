package model;

import java.util.HashMap;
import java.util.UUID;

public class Expense {

	private String expenseId;
	private double amount;
	private SplitType splitType;
	private User paidBy;
	private HashMap<String, Split> splits;

	public Expense(double amount, SplitType splitType,User paidBy) {
		super();
		this.expenseId = UUID.randomUUID().toString();
		this.amount = amount;
		this.splitType = splitType;
		this.paidBy = paidBy;
		this.splits = new HashMap<>();
	}

	public User getPaidBy() {
		return paidBy;
	}

	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}

	public double getAmount() {
		return amount;
	}

	public SplitType getSplitType() {
		return splitType;
	}

	public void setSplits(HashMap<String, Split> splits) {
		this.splits = splits;
	}

	public HashMap<String, Split> getSplits() {
		return splits;
	}

}
