package April2021PrepLeetcode;

import java.util.Stack;

public class _1047RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("aaaaaaaaa"));
	}

	public static String removeDuplicates(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

}
