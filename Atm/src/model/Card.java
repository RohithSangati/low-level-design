package model;

public class Card {

	private final long cardNumber;
	private long pin;

	public Card(long cardNumber) {
		this.cardNumber = cardNumber;
		this.pin = -1;
	}

	public void setOrResetPin(long pin) {
		if ((pin + "").length() == 6) {
			this.pin = pin;
			System.out.println("Successfull resetted pin");
		} else {
			System.out.println("Pin length should be exactly 6");
		}
	}

	public boolean validate(long pin) {
		if (this.pin == -1) {
			System.out.println("Please generate pin to continue ATM services");
		}
		return this.pin == pin;
	}

	public long getCardNumber() {
		return cardNumber;
	}

}
