package model;

public class Number implements ArthimeticExpression {

	public int value;

	public Number(int value) {
		this.value = value;
	}

	public int evaluate() {
		return this.value;
	}

}
