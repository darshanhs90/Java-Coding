package May2021GoogLeetcode;

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
		HashSet<String> output = new HashSet<String>();
		dfs(0, 0, 0, s, "", output);
		return new ArrayList<String>(output);
	}

	public static void dfs(int index, int left, int right, String s, String str, HashSet<String> output) {
		if (index == s.length()) {
			if (left == right) {
				if (output.isEmpty()) {
					output.add(str);
				} else {
					String top = output.iterator().next();
					if (str.length() > top.length()) {
						output.clear();
						output.add(str);
					} else if (str.length() == top.length()) {
						output.add(str);
					}
				}
			}
			return;
		}

		if (right > left)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, left + 1, right, s, str + "(", output);
			dfs(index + 1, left, right, s, str, output);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, s, str + ")", output);
			dfs(index + 1, left, right, s, str, output);
		} else {
			dfs(index + 1, left, right, s, str + c, output);
		}
	}

}
