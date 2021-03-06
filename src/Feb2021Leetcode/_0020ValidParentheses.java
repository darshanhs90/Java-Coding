package Feb2021Leetcode;

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
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
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
