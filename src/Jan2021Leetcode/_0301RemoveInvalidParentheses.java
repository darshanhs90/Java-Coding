package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0301RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	static int maxLength;

	public static List<String> removeInvalidParentheses(String s) {
		maxLength = 0;
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		HashSet<String> set = new HashSet<String>();
		dfs(0, 0, 0, s, "", map, set);
		return map.get(maxLength);
	}

	public static void dfs(int index, int leftCount, int rightCount, String s, String currString,
			HashMap<Integer, List<String>> map, HashSet<String> set) {
		if (index == s.length() && leftCount == rightCount) {
			if (!set.contains(currString)) {
				maxLength = Math.max(maxLength, currString.length());
				if (map.containsKey(currString.length())) {
					map.get(currString.length()).add(currString);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(currString);
					map.put(currString.length(), list);
				}
				set.add(currString);
			}
			return;
		}

		if (index >= s.length() || rightCount > leftCount)
			return;

		char c = s.charAt(index);
		if (c == '(') {
			dfs(index + 1, leftCount + 1, rightCount, s, currString + "(", map, set);
			dfs(index + 1, leftCount, rightCount, s, currString, map, set);
		} else if (c == ')') {
			dfs(index + 1, leftCount, rightCount + 1, s, currString + ")", map, set);
			dfs(index + 1, leftCount, rightCount, s, currString, map, set);
		} else {
			dfs(index + 1, leftCount, rightCount, s, currString + c, map, set);
		}
	}

}
