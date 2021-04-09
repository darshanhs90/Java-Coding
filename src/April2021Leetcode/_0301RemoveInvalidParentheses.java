package April2021Leetcode;

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
		dfs(0, 0, 0, s, "", output);
		return new ArrayList<String>(output);
	}

	public static void dfs(int index, int left, int right, String s, String currString, HashSet<String> set) {
		if (index == s.length() && left == right) {
			if (set.isEmpty()) {
				set.add(currString);
			} else {
				String str = set.iterator().next();
				if (currString.length() > str.length()) {
					set.clear();
					set.add(currString);
				} else if (currString.length() == str.length()) {
					set.add(currString);
				}
			}
			return;
		}
		if (index >= s.length() || right > left)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, left + 1, right, s, currString + "(", set);
			dfs(index + 1, left, right, s, currString, set);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, s, currString + ")", set);
			dfs(index + 1, left, right, s, currString, set);
		} else {
			dfs(index + 1, left, right, s, currString + c, set);
		}
	}

}
