package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0301RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> output = new ArrayList<String>();
		if (s == null)
			return output;
		dfs(0, 0, 0, "", s, output);
		return output;
	}

	public static void dfs(int index, int left, int right, String currString, String s, List<String> list) {
		if (right > left)
			return;
		if (left == right) {
			if (list.isEmpty()) {
				list.add(currString);
			} else if (currString.length() > list.get(0).length()) {
				list.clear();
				list.add(currString);
			} else if (currString.length() == list.get(0).length() && !list.contains(currString)) {
				list.add(currString);
			}
		}

		if (index >= s.length())
			return;

		char c = s.charAt(index);

		if (c == '(') {

			dfs(index + 1, left + 1, right, currString + c, s, list);
			dfs(index + 1, left, right, currString, s, list);
		} else if (c == ')') {
			dfs(index + 1, left, right + 1, currString + c, s, list);
			dfs(index + 1, left, right, currString, s, list);
		} else {
			dfs(index + 1, left, right, currString + c, s, list);
		}
	}

}
