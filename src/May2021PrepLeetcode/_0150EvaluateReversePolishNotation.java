package May2021PrepLeetcode;

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
		for (String token : tokens) {
			if (token.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (token.equals("-")) {
				int valNew = stack.pop();
				int valOld= stack.pop();
				stack.push(valOld-valNew);
			} else if (token.equals("*")) {
				int valNew = stack.pop();
				int valOld= stack.pop();
				stack.push(valOld*valNew);
			} else if (token.equals("/")) {
				int valNew = stack.pop();
				int valOld= stack.pop();
				stack.push(valOld/valNew);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}
}
