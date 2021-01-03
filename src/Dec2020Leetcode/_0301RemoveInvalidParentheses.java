package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0301RemoveInvalidParentheses {

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

	static int maxVal;

	public static List<String> removeInvalidParentheses(String s) {
		maxVal = 0;
		HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
		dfs(0, 0, 0, "", s, map);
		List<String> list = new ArrayList<String>();
		Iterator<String> iter = map.get(maxVal).iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}

	public static void dfs(int index, int left, int right, String currString, String s,
			HashMap<Integer, HashSet<String>> map) {
		if (right > left)
			return;
		if (left == right && currString.length() >= maxVal) {
			if (map.containsKey(currString.length())) {
				map.get(currString.length()).add(currString);
			} else {
				HashSet<String> set = new HashSet<String>();
				set.add(currString);
				map.put(currString.length(), set);
			}
			maxVal = Math.max(currString.length(), maxVal);
		}

		if (index >= s.length())
			return;

		char c = s.charAt(index);
		if (s.charAt(index) == '(') {
			dfs(index + 1, left + 1, right, currString + c, s, map);
			dfs(index + 1, left, right, currString, s, map);
		} else if (s.charAt(index) == ')') {
			dfs(index + 1, left, right + 1, currString + c, s, map);
			dfs(index + 1, left, right, currString, s, map);
		} else {
			dfs(index + 1, left, right, currString + c, s, map);
		}
	}

}
