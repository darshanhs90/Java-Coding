package Mar2021Leetcode;

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

	public static void dfs(int index, int left, int right, String currString, String s, HashSet<String> out) {
		if (index == s.length() && left == right) {
			if (out.isEmpty()) {
				out.add(currString);
			} else {
				String prevString = out.iterator().next();
				if (prevString.length() < currString.length()) {
					out.clear();
					out.add(currString);
				} else if (prevString.length() == currString.length()) {
					out.add(currString);
				}
			}
			return;
		}

		if (index >= s.length() || right > left)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, left + 1, right, currString + "(", s, out);
			dfs(index + 1, left, right, currString, s, out);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, currString + ")", s, out);
			dfs(index + 1, left, right, currString, s, out);
		} else {
			dfs(index + 1, left, right, currString + c, s, out);
		}
	}

}
