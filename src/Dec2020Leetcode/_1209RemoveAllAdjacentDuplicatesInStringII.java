package Dec2020Leetcode;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
	}

	public static String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < sb.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(1);
			} else {
				if (sb.charAt(i) == sb.charAt(i - 1)) {
					int currCount = stack.pop();
					if (currCount + 1 == k) {
						sb.delete(i - k + 1, i + 1);
						i = i - k;
					} else {
						stack.push(currCount + 1);
					}
				} else {
					stack.push(1);
				}
			}
		}
		return sb.toString();
	}

	public static String removeDuplicates1(String s, int k) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && stack.size() >= k - 1 && stack.peek() == c) {
				Stack<Character> revStack = new Stack<Character>();
				boolean removeSucceeded = true;
				for (int j = 1; j < k; j++) {
					if (stack.isEmpty() || stack.peek() != c) {
						removeSucceeded = false;
						break;
					}
					revStack.push(stack.pop());
				}

				if (!removeSucceeded) {
					while (!revStack.isEmpty()) {
						stack.push(revStack.pop());
					}
					stack.push(c);
				}
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.reverse().toString();
	}
}
