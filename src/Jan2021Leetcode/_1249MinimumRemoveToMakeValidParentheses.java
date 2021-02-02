package Jan2021Leetcode;

import java.util.Stack;

public class _1249MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	public static String minRemoveToMakeValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder(s);
		int index = 0;
		while (index < sb.length()) {
			char c = sb.charAt(index);
			if (c == '(') {
				stack.push(c);
				index++;
			} else if (c == ')') {
				if (stack.isEmpty()) {
					sb.deleteCharAt(index);
				} else {
					stack.pop();
					index++;
				}
			} else {
				index++;
			}
		}

		sb = sb.reverse();
		stack = new Stack<Character>();
		index = 0;
		while (index < sb.length()) {
			char c = sb.charAt(index);
			if (c == ')') {
				stack.push(c);
				index++;
			} else if (c == '(') {
				if (stack.isEmpty()) {
					sb.deleteCharAt(index);
				} else {
					stack.pop();
					index++;
				}
			} else {
				index++;
			}
		}
		return sb.reverse().toString();
	}

}
