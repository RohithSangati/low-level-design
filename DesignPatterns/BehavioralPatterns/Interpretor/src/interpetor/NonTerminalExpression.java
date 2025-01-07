package interpetor;

import context.Context;

public class NonTerminalExpression implements Expression {

	Expression leftExpression;
	Expression rightExpression;
	public String operation;

	public NonTerminalExpression(Expression leftExpression, Expression rightExpression, String operation) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operation = operation;
	}

	public int interpret(Context context) {
		switch (this.operation) {
		case "+":
			return leftExpression.interpret(context) + rightExpression.interpret(context);
		case "-":
			return leftExpression.interpret(context) - rightExpression.interpret(context);
		case "*":
			return leftExpression.interpret(context) * rightExpression.interpret(context);
		case "/":
			return leftExpression.interpret(context) / rightExpression.interpret(context);
		default:
			return 0;
		}
	}

}
