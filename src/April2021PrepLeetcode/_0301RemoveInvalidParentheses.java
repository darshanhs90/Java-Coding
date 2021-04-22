package April2021PrepLeetcode;

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
		if (s == null || s.length() == 0)
			return new ArrayList<String>(output);
		dfs(0, 0, 0, "", s, output);
		return new ArrayList<String>(output);
	}

	public static void dfs(int left, int right, int index, String currString, String s, HashSet<String> output) {
		if (right > left)
			return;

		if (left == right && index == s.length()) {
			if (output.isEmpty()) {
				output.add(currString);
			} else {
				String popStr = output.iterator().next();
				if (currString.length() > popStr.length()) {
					output.clear();
					output.add(currString);
				} else if (currString.length() == popStr.length()) {
					output.add(currString);
				}
			}
			return;
		}

		if (index >= s.length())
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(left + 1, right, index + 1, currString + c, s, output);
			dfs(left, right, index + 1, currString, s, output);
		} else if (c == ')') {
			dfs(left, right + 1, index + 1, currString + c, s, output);
			dfs(left, right, index + 1, currString, s, output);
		} else {
			dfs(left, right, index + 1, currString + c, s, output);
		}
	}

}
