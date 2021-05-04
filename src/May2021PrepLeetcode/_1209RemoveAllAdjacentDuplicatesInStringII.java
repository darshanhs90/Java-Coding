package May2021PrepLeetcode;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesInStringII {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				stack.push(1);
			} else {
				int count = stack.pop() + 1;

				if (count == k) {
					sb = sb.delete(i - k + 1, i + 1);
					i = i - k;
				} else {
					stack.push(count);
				}
			}
		}
		return sb.toString();
	}
}
