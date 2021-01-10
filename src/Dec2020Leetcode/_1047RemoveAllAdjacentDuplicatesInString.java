package Dec2020Leetcode;

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
		stack.push(str.charAt(0));
		for (int i = 1; i < str.length();) {
			char c = str.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				i++;
			} else {
				if (stack.peek() != c) {
					stack.push(c);
					i++;
				} else {
					int count = 0;
					while (i < str.length() && str.charAt(i) == stack.peek() && count<1) {
						i++;
						count++;
					}
					stack.pop();
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
