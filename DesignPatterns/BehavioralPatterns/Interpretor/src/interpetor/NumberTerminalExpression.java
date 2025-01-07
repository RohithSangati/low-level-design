package interpetor;

import context.Context;

public class NumberTerminalExpression implements Expression {

	public String stringValue;

	public NumberTerminalExpression(String stringValue) {
		this.stringValue = stringValue;
	}

	public int interpret(Context context) {
		return context.get(this.stringValue);
	}

}
