package May2021Leetcode;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesInStringII2 {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd"));
		System.out.println(removeDuplicates("deeedbbcccbdaa"));
		System.out.println(removeDuplicates("pbbcggttciiippooaais"));
	}

	static class Pair {
		char key;
		int val;

		public Pair(char key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static String removeDuplicates(String s) {
		Stack<Pair> stack = new Stack<Pair>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(new Pair(c, 1));
			} else {
				if (stack.peek().key == c) {
					stack.peek().val += 1;
				} else {
					if (stack.peek().val > 1) {
						stack.pop();
					}

					if (!stack.isEmpty() && stack.peek().key == c) {
						stack.peek().val += 1;
					} else {
						stack.push(new Pair(c, 1));
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek().val > 1) {
				stack.pop();
			} else {
				sb.append(stack.pop().key);
			}
		}

		return sb.reverse().toString();
	}
}
