package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.List;

public class _045RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	static int minRemoved;

	public static List<String> removeInvalidParentheses(String s) {
		List<String> list = new ArrayList<String>();
		minRemoved = Integer.MAX_VALUE;
		removeInvalidParentheses(0, 0, 0, 0, "", s, list);
		return list;
	}

	public static void removeInvalidParentheses(int index, int leftCount, int rightCount, int removed,
			String currString, String s, List<String> list) {
		if (rightCount > leftCount || removed > minRemoved)
			return;

		if (index == s.length()) {
			if (leftCount == rightCount) {
				if (removed < minRemoved) {
					list.clear();
					minRemoved = removed;
				}
				if (!list.contains(currString))
					list.add(currString);
			}
			return;
		}

		char c = s.charAt(index);
		if (c == '(' || c == ')') {
			if (c == '(') {
				removeInvalidParentheses(index + 1, leftCount + 1, rightCount, removed, currString + c, s, list);
				removeInvalidParentheses(index + 1, leftCount, rightCount, removed + 1, currString, s, list);
			} else {
				removeInvalidParentheses(index + 1, leftCount, rightCount + 1, removed, currString + c, s, list);
				removeInvalidParentheses(index + 1, leftCount, rightCount, removed + 1, currString, s, list);
			}
		} else {
			removeInvalidParentheses(index + 1, leftCount, rightCount, removed, currString + c, s, list);
		}
	}

}
