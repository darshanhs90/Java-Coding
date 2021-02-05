package Jan2021Leetcode;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
	}

	static class Pair {
		char c;
		int count;

		public Pair(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(new Pair(c, 1));
			} else {
				if (stack.peek().c == c) {
					if (stack.peek().count + 1 == k)
						stack.pop();
					else {
						Pair p = stack.pop();
						stack.push(new Pair(c, p.count + 1));
					}
				} else {
					stack.push(new Pair(c, 1));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Pair p = stack.pop();

			for (int i = 0; i < p.count; i++) {
				sb.append(p.c);
			}
		}
		return sb.reverse().toString();
	}
}
