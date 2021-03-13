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
		removeParentheses(0, 0, 0, "", s, output);
		return output;
	}

	public static void removeParentheses(int left, int right, int index, String currString, String s,
			List<String> output) {
		if (index == s.length() && left == right) {
			if (output.isEmpty()) {
				output.add(currString);
			} else {
				String str = output.get(0);
				if (str.length() < currString.length()) {
					output.clear();
					output.add(currString);
				} else if (str.length() == currString.length() && !output.contains(currString)) {
					output.add(currString);
				}
			}
			return;
		}
		if (index >= s.length() || right > left)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			removeParentheses(left + 1, right, index + 1, currString + "(", s, output);
			removeParentheses(left, right, index + 1, currString, s, output);
		} else if (c == ')') {
			removeParentheses(left, right + 1, index + 1, currString + ")", s, output);
			removeParentheses(left, right, index + 1, currString, s, output);
		} else {
			removeParentheses(left, right, index + 1, currString + c, s, output);
		}
	}

}
