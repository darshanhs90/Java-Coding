package FacebookPrep;

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
		HashSet<String> set = new HashSet<String>(wordDict);
		List<String> output = new ArrayList<String>();
		dfs(0, s, set, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(int index, String s, HashSet<String> wordDict, List<String> tempList, List<String> output) {
		if (index == s.length()) {
			output.add(String.join(" ", tempList));
			return;
		}

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (wordDict.contains(str)) {
				tempList.add(str);
				dfs(i + 1, s, wordDict, tempList, output);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
