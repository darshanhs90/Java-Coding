package May2021Leetcode;

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
		if (s == null || s.length() == 0)
			return new ArrayList<String>();
		HashSet<String> out = new HashSet<String>();
		dfs(0, 0, 0, s, "", out);
		return new ArrayList<String>(out);
	}

	public static void dfs(int index, int left, int right, String s, String str, HashSet<String> out) {
		if (index == s.length()) {
			if (left == right) {
				if (out.isEmpty()) {
					out.add(str);
				} else {
					String poppedString = out.iterator().next();

					if (str.length() > poppedString.length()) {
						out.clear();
						out.add(str);
					} else if (str.length() == poppedString.length()) {
						out.add(str);
					}
				}
			}
			return;
		}

		if (right > left)
			return;

		char c = s.charAt(index);

		if (c == '(') {
			dfs(index + 1, left + 1, right, s, str + "(", out);
			dfs(index + 1, left, right, s, str, out);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, s, str + ")", out);
			dfs(index + 1, left, right, s, str, out);
		} else {
			dfs(index + 1, left, right, s, str + c, out);
		}
	}

}
