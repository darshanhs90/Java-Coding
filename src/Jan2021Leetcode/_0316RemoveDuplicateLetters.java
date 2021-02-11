package Jan2021Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class _0316RemoveDuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

	public static String removeDuplicateLetters(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.contains(c))
				continue;

			if (stack.isEmpty() || c > stack.peek()) {
				stack.push(c);
			} else {
				while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
					stack.pop();
				}
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder(stack.size());
		for (Character c : stack)
			sb.append(c.charValue());
		return sb.toString();
	}
}
