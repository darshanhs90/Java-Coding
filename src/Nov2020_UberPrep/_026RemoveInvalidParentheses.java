package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.List;

public class _026RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	static int maxLength = 0;

	public static List<String> removeInvalidParentheses(String s) {
		List<String> list = new ArrayList<String>();
		maxLength = 0;
		dfs("", 0, 0, 0, s, list);
		return list;
	}

	public static void dfs(String currString, int index, int left, int right, String s, List<String> list) {
		if (right > left)
			return;

		if (left == right) {
			if (currString.length() > maxLength) {
				list.clear();
				list.add(currString);
				maxLength = currString.length();
			} else if (currString.length() == maxLength && !list.contains(currString)) {
				list.add(currString);
			}
		}

		if (index >= s.length())
			return;

		char currChar = s.charAt(index);
		// Add char
		if (currChar == '(') {
			dfs(currString + currChar, index + 1, left + 1, right, s, list);
			dfs(currString, index + 1, left, right, s, list);
		} else if (currChar == ')') {
			dfs(currString + currChar, index + 1, left, right + 1, s, list);
			dfs(currString, index + 1, left, right, s, list);
		} else {
			dfs(currString + currChar, index + 1, left, right, s, list);
		}
	}

}
