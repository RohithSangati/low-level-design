package interpetor;

import context.Context;

public class DivideNonTerminalExpression implements Expression {

	Expression leftExpression;
	Expression rightExpression;

	public DivideNonTerminalExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	public int interpret(Context context) {
		return leftExpression.interpret(context) * rightExpression.interpret(context);
	}

}
