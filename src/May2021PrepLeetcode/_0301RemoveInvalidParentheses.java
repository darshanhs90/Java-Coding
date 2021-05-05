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
		HashSet<String> output = new HashSet<String>();
		dfs(0, 0, 0, "", s, output);
		return new ArrayList<String>(output);
	}

	public static void dfs(int index, int left, int right, String str, String s, HashSet<String> output) {
		if (index == s.length()) {
			if (left == right) {
				if (output.isEmpty()) {
					output.add(str);
				} else {
					String first = output.iterator().next();
					if (str.length() > first.length()) {
						output.clear();
						output.add(str);
					} else if (str.length() == first.length()) {
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
			dfs(index + 1, left + 1, right, str + "(", s, output);
			dfs(index + 1, left, right, str, s, output);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, str + ")", s, output);
			dfs(index + 1, left, right, str, s, output);
		} else {
			dfs(index + 1, left, right, str + c, s, output);
		}
	}

}
