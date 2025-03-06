package model;

import java.util.UUID;

public class Transaction {
	private String transactionId;
	private User sender;
	private User receiver;
	private Double amount;

	public Transaction(User sender, User receiver, Double amount) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public User getSender() {
		return sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public Double getAmount() {
		return amount;
	}
}
