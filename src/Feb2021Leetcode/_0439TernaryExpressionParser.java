package Feb2021Leetcode;

import java.util.Stack;

public class _0439TernaryExpressionParser {

	public static void main(String[] args) {
		System.out.println(parseTernary("T?2:3"));
		System.out.println(parseTernary("F?1:T?4:5"));
		System.out.println(parseTernary("T?T?F:5:3"));
	}

	public static String parseTernary(String expression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (stack.isEmpty() || stack.peek() != '?') {
				stack.push(c);
			} else {

				stack.pop();
				char c1 = stack.pop();
				stack.pop();
				char c2 = stack.pop();

				if (c == 'T') {
					stack.push(c1);
				} else {
					stack.push(c2);
				}
			}
		}
		return stack.peek() + "";
	}

}
