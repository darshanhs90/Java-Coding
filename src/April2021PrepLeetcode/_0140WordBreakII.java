package April2021PrepLeetcode;

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
		dfs(0, s, new ArrayList<String>(), output, new HashSet<String>(wordDict));
		return output;
	}

	public static void dfs(int index, String s, List<String> tempList, List<String> output, HashSet<String> wordSet) {
		if (index == s.length()) {
			String str = String.join(" ", tempList);
			output.add(str);
			return;
		}

		for (int i = index; i < s.length(); i++) {
			String str = s.substring(index, i + 1);
			if (wordSet.contains(str)) {
				tempList.add(str);
				dfs(i + 1, s, tempList, output, wordSet);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
