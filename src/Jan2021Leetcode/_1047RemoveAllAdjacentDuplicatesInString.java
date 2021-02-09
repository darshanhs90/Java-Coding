package Jan2021Leetcode;

import java.util.Stack;

public class _1047RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("aaaaaaaaa"));
	}

	public static String removeDuplicates(String str) {
		if (str == null || str.length() < 2)
			return str;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (stack.isEmpty() || stack.peek() != c) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}

}
