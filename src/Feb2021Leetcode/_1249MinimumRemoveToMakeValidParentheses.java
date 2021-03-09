package Feb2021Leetcode;

import java.util.Stack;

public class _1249MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	public static String minRemoveToMakeValid(String s) {
		if (s == null || s.length() == 0)
			return s;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
				sb.append(c);
			} else if (c == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
					sb.append(c);
				}
			} else {
				sb.append(c);
			}
		}

		s = sb.toString();
		sb = new StringBuilder();
		stack.clear();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				stack.push(c);
				sb.append(c);
			} else if (c == '(') {
				if (!stack.isEmpty()) {
					stack.pop();
					sb.append(c);
				}
			} else {
				sb.append(c);
			}
		}
		return sb.reverse().toString();
	}

}
