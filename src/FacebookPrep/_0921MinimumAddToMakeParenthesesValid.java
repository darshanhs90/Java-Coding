package FacebookPrep;

import java.util.Stack;

public class _0921MinimumAddToMakeParenthesesValid {
	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("())"));
		System.out.println(minAddToMakeValid("((("));
		System.out.println(minAddToMakeValid("()"));
		System.out.println(minAddToMakeValid("()))(("));
	}

	public static int minAddToMakeValid(String s) {
		if (s == null || s.length() == 0)
			return 0;
		String originalString = s;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				sb.append(c);
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					sb.append("()");
				} else {
					sb.append(")");
					stack.pop();
				}
			}
		}

		s = sb.toString();
		sb = new StringBuilder();
		stack = new Stack<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				sb.append(c);
				stack.push(c);
			} else if (c == '(') {
				if (stack.isEmpty()) {
					sb.append("()");
				} else {
					sb.append("(");
					stack.pop();
				}
			}
		}

		return sb.length() - originalString.length();
	}
}
