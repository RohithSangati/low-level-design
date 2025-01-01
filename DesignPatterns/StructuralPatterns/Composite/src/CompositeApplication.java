import model.ArthimeticExpression;
import model.Expression;
import model.Number;
import model.Operator;

public class CompositeApplication {

	public static void main(String[] args) {
		ArthimeticExpression num1 = new Number(1);
		ArthimeticExpression num2 = new Number(3);

		ArthimeticExpression expression1 = new Expression(num1, num2, Operator.ADD);

		ArthimeticExpression num3 = new Number(2);
		ArthimeticExpression num4 = new Number(4);

		ArthimeticExpression expression2 = new Expression(num3, num4, Operator.MULTIPLY);

		ArthimeticExpression finalExpression = new Expression(expression2, expression1, Operator.SUBTRACT);

		System.out.print(finalExpression.evaluate());
	}

}