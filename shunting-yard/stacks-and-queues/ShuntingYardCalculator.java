/**
 * Implements the shunting yard algorithm to evalute arithmetic expressions.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-23
 */
public class ShuntingYardCalculator {

	/** Drives execution. */
	public static void main(String[] args) {
		String infix = "((2 + (3 * 5)) – (12 / 4))";
		String[] infixTokenized = {"(","(","2","+","(","3","*","5",")",")","-","(","12","/","4",")",")"};
		Queue<String> infixQueue = new LinkedQueue<>();
		for (String token : infixTokenized) {
			infixQueue.enqueue(token);
		}

		double result = evaluteInfix(infixQueue);
		System.out.println(infix + " = " + result);

		String postfix = "2 3 5 * + 12 4 / -";
		String[] postfixTokenized = {"2", "3", "5", "*", "+", "12", "4", "/", "-"};
		Queue<String> postfixQueue = new LinkedQueue<>();
		for (String token : postfixTokenized) {
			postfixQueue.enqueue(token);
		}
		result = evaluatePostfix(postfixQueue);
		System.out.println(postfix + " = " + result);
	}

	/** Evaluates a postfix expression. */
	public static double evaluatePostfix(Queue<String> expression) {
		Stack<Double> valueStack = new LinkedStack<>();
		for (String token : expression) {
			if (isOperator(token)) {
				double rightValue = valueStack.pop();
				double leftValue = valueStack.pop();
				valueStack.push(evaluate(token, leftValue, rightValue));
			} else if (isValue(token)) {
				valueStack.push(Double.parseDouble(token));
			}
		}
		return valueStack.peek();
	}

	/** Evaluates a fully-parenthesized infix expression. */
	public static double evaluteInfix(Queue<String> expression) {
		Stack<Double> valueStack = new LinkedStack<>();
		Stack<String> operatorStack = new LinkedStack<>();
		for (String token : expression) {
			if (isOperator(token)) {
				operatorStack.push(token);
			} else if (isValue(token)) {
				valueStack.push(Double.parseDouble(token));
			} else if (token.equals(")")) {
				String operator = operatorStack.pop();
				double rightValue = valueStack.pop();
				double leftValue = valueStack.pop();
				valueStack.push(evaluate(operator, leftValue, rightValue));
			}
		}
		return valueStack.peek();
	}

	/** Returns true if the given string is an operator, false otherwise. */
	private static boolean isOperator(String str) {
		switch (str) {
			case "+" : return true;
			case "-" : return true;
			case "*" : return true;
			case "/" : return true;
			default  : return false;
		}
	}

	/** Returns true if the given string can be parsed as an integer. Kludge. */
	private static boolean isValue(String str) {
		try {
			double value = Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/** Evaluates the given binary expression. */
	private static double evaluate(String operator, double leftValue, double rightValue) {
		assert isOperator(operator);
		switch (operator) {
			case "+" : return leftValue + rightValue;
			case "-" : return leftValue - rightValue;
			case "*" : return leftValue * rightValue;
			case "/" : return leftValue / rightValue;
			default  : return 0d;
		}
	}
}
