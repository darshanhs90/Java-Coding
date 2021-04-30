package May2021PrepLeetcode;

import java.util.Stack;

public class _0020ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[')
						|| (c == '}' && stack.peek() != '{')) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
