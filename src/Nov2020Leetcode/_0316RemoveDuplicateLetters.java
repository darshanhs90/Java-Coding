package Nov2020Leetcode;

import java.util.Stack;

public class _0316RemoveDuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

	public static String removeDuplicateLetters(String s) {
		char[] charArr = s.toCharArray();
		int[] count = new int[26];
		for (int i = 0; i < charArr.length; i++) {
			count[charArr[i] - 'a']++;
		}
		boolean[] visited = new boolean[26];
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			count[c - 'a']--;
			if (visited[c - 'a'] == true)
				continue;

			while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			visited[c - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}
}
