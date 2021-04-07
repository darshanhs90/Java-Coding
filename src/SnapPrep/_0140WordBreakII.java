package SnapPrep;

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
		List<String> output = new ArrayList<String>();
		HashSet<String> wordSet = new HashSet<String>(wordDict);

		dfs(0, s, wordSet, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(int index, String s, HashSet<String> wordSet, List<String> list, List<String> output) {
		if (index == s.length()) {
			String str = String.join(" ", list);
			output.add(str);
			return;
		}

		if (index > s.length())
			return;

		for (int i = index; i < s.length(); i++) {
			String str = s.substring(index, i + 1);
			if (wordSet.contains(str)) {
				list.add(str);
				dfs(i + 1, s, wordSet, list, output);
				list.remove(list.size() - 1);
			}
		}
	}

}
