package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0140WordBreakII {

	public static void main(String[] args) {
		System.out.println(wordBreak("applepenapple",
				new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
		System.out.println(
				wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

		System.out.println(
				wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> out = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return out;

		HashSet<String> set = new HashSet<String>(wordDict);
		dfs(0, s, set, new ArrayList<String>(), out);
		return out;
	}

	public static void dfs(int index, String s, HashSet<String> set, List<String> list, List<String> out) {
		if (index == s.length()) {
			out.add(String.join(" ", list));
			return;
		}

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (set.contains(str)) {
				list.add(str);
				dfs(i + 1, s, set, list, out);
				list.remove(list.size() - 1);
			}
		}
	}

}
