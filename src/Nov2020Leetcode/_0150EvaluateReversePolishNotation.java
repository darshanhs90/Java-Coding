package Nov2020Leetcode;

import java.util.Stack;

public class _0150EvaluateReversePolishNotation {

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out
				.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String currString = tokens[i];
			if (currString.contentEquals("+")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val1 + val2);
			} else if (currString.contentEquals("-")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2 - val1);
			} else if (currString.contentEquals("*")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val1 * val2);
			} else if (currString.contentEquals("/")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2 / val1);
			} else {
				stack.push(Integer.parseInt(currString));
			}
		}
		return stack.peek();
	}
}
