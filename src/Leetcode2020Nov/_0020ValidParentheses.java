package Leetcode2020Nov;

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
		Stack<Character> charStack = new Stack<Character>();
		if (s.length() % 2 == 1)
			return false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				charStack.add(c);
			} else if ((c == ')' || c == '}' || c == ']') && !charStack.isEmpty()) {
				char peekChar = charStack.peek();
				if ((c == ')' && peekChar == '(') || (c == ']' && peekChar == '[') || (c == '}' && peekChar == '{')) {
					charStack.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}

		}
		return charStack.isEmpty();
	}
}
