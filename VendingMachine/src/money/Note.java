package money;

public enum Note {
	ONE(1), FIVE(5), TEN(10), TWENTY(20);

	private int value;

	Note(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
