package model;

public class Expression implements ArthimeticExpression {

	public ArthimeticExpression leftExpression;
	public ArthimeticExpression rightExpression;
	public Operator operator;

	public Expression(ArthimeticExpression leftExpression, ArthimeticExpression rightExpression, Operator operator) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operator = operator;
	}

	public int evaluate() {
		switch (this.operator) {
		case ADD:
			return this.leftExpression.evaluate() + this.rightExpression.evaluate();
		case SUBTRACT:
			return this.leftExpression.evaluate() - this.rightExpression.evaluate();
		case MULTIPLY:
			return this.leftExpression.evaluate() * this.rightExpression.evaluate();
		case DIVIDE:
			return this.leftExpression.evaluate() / this.rightExpression.evaluate();
		}
		return 0;
	}

}
