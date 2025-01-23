package money;

public enum Coin {
	PENNY(0.01), NICKLE(0.05), DIME(0.1), QUARTER(0.25);

	private double value;

	private Coin(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}
