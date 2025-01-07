package interpetor;

import context.Context;

public class SumNonTerminalExpression implements Expression {

	Expression leftExpression;
	Expression rightExpression;

	public SumNonTerminalExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	public int interpret(Context context) {
		return leftExpression.interpret(context) + rightExpression.interpret(context);
	}

}
