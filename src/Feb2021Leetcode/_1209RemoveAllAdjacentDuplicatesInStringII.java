package Feb2021Leetcode;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
	}

	static class Pair {
		char val;
		int count;

		public Pair(char val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty() || stack.peek().val != c) {
				stack.push(new Pair(c, 1));
			} else {
				Pair p = stack.pop();
				p.count++;

				if (p.count != k) {
					stack.push(p);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Pair p = stack.pop();
			for (int i = 0; i < p.count; i++) {
				sb.append(p.val);
			}
		}
		return sb.reverse().toString();
	}
}
