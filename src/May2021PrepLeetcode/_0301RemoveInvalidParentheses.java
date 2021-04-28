package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0301RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	public static List<String> removeInvalidParentheses(String s) {
		if (s == null)
			return new ArrayList<String>();
		HashSet<String> output = new HashSet<String>();
		dfs(0, 0, 0, s, "", output);
		return new ArrayList<String>(output);
	}

	public static void dfs(int index, int left, int right, String s, String currString, HashSet<String> out) {
		if (right > left)
			return;

		if (index == s.length()) {
			if (left != right)
				return;

			if (out.isEmpty()) {
				out.add(currString);
			} else {
				String peekString = out.iterator().next();
				if (currString.length() > peekString.length()) {
					out.clear();
					out.add(currString);
				} else if (currString.length() == peekString.length()) {
					out.add(currString);
				}
			}
			return;
		}

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, left + 1, right, s, currString + "(", out);
			dfs(index + 1, left, right, s, currString, out);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, s, currString + ")", out);
			dfs(index + 1, left, right, s, currString, out);
		} else {
			dfs(index + 1, left, right, s, currString + c, out);
		}
	}

}
