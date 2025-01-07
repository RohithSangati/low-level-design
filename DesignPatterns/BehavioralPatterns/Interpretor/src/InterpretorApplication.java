import context.Context;
import interpetor.Expression;
import interpetor.MultiplyNonTerminalExpression;
import interpetor.NumberTerminalExpression;
import interpetor.SubtractNonTerminalExpression;
import interpetor.SumNonTerminalExpression;

public class InterpretorApplication {

	public static void main(String[] args) {

		Context context = new Context();

		context.put("one", 1);
		context.put("two", 2);
		context.put("three", 3);

		Expression exp1 = new NumberTerminalExpression("one");
		Expression exp2 = new NumberTerminalExpression("two");

		Expression finalExp1 = new SumNonTerminalExpression(exp1, exp2);

		Expression exp3 = new NumberTerminalExpression("three");
		Expression exp4 = new NumberTerminalExpression("two");

		Expression finalExp2 = new SubtractNonTerminalExpression(exp3, exp4);

		Expression finalExpression = new MultiplyNonTerminalExpression(finalExp1, finalExp2);

		System.out.println(finalExpression.interpret(context));
	}

}