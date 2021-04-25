package April2021PrepLeetcode;

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
		for (String str : tokens) {
			if (str.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (str.equals("-")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num2 - num1);
			} else if (str.equals("*")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num1 * num2);
			} else if (str.equals("/")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num2 / num1);
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.peek();
	}
}
