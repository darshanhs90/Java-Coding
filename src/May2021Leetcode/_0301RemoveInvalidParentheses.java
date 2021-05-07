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
		HashSet<String> out = new HashSet<String>();
		dfs(0, 0, 0, "", s, out);
		return new ArrayList<String>(out);
	}

	public static void dfs(int index, int left, int right, String str, String s, HashSet<String> set) {
		if (index == s.length()) {
			if (left == right) {
				if (set.isEmpty()) {
					set.add(str);
				} else {
					String pop = set.iterator().next();
					if (str.length() > pop.length()) {
						set.clear();
						set.add(str);
					} else if (str.length() == pop.length()) {
						set.add(str);
					}
				}
			}
			return;
		}
		if (right > left)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, left + 1, right, str + c, s, set);
			dfs(index + 1, left, right, str, s, set);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, str + c, s, set);
			dfs(index + 1, left, right, str, s, set);
		} else {
			dfs(index + 1, left, right, str + c, s, set);
		}
	}

}
