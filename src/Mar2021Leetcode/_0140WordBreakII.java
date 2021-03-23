package Mar2021Leetcode;

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
		HashSet<String> wordSet = new HashSet<String>(wordDict);
		List<String> output = new ArrayList<String>();
		dfs(0, s, wordSet, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(int index, String s, HashSet<String> set, List<String> tempList, List<String> output) {
		if (index == s.length()) {
			String str = String.join(" ", tempList);
			output.add(str);
			return;
		}

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (set.contains(str)) {
				tempList.add(str);
				dfs(i + 1, s, set, tempList, output);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
