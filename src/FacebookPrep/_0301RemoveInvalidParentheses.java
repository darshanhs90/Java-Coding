package FacebookPrep;

import java.util.ArrayList;
import java.util.List;

public class _0301RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> list = new ArrayList<String>();
		if (s == null)
			return list;
		removeInvalidParentheses(0, "", 0, 0, s, list);
		return list;
	}

	public static void removeInvalidParentheses(int index, String currString, int left, int right, String s,
			List<String> list) {
		if (right > left)
			return;

		if (index == s.length() && left == right) {
			if (list.isEmpty()) {
				list.add(currString);
			} else {
				if (list.get(0).length() < currString.length()) {
					list.clear();
					list.add(currString);
				} else if (list.get(0).length() == currString.length() && !list.contains(currString)) {
					list.add(currString);
				}
			}
			return;
		}
		if (index >= s.length())
			return;

		char c = s.charAt(index);
		if (c == '(') {
			removeInvalidParentheses(index + 1, currString + c, left + 1, right, s, list);
			removeInvalidParentheses(index + 1, currString, left, right, s, list);
		} else if (c == ')') {
			removeInvalidParentheses(index + 1, currString + c, left, right + 1, s, list);
			removeInvalidParentheses(index + 1, currString, left, right, s, list);
		} else {
			removeInvalidParentheses(index + 1, currString + c, left, right, s, list);
		}
	}

}
