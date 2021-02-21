package DropboxPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0140WordBreakII {

	public static void main(String[] args) {
		System.out.println(
				wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

		System.out.println(wordBreak("pineapplepenapple",
				new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));

		System.out.println(
				wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		HashSet<String> wordSet = new HashSet<String>(wordDict);
		List<String> output = new ArrayList<String>();
		wordBreak(0, s, wordSet, new ArrayList<String>(), output);
		return output;
	}

	public static void wordBreak(int index, String s, HashSet<String> wordSet, List<String> tempList,
			List<String> output) {
		if (index == s.length()) {
			String str = String.join(" ", tempList);
			output.add(str);
			return;
		}

		if (index >= s.length())
			return;

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);

			if (wordSet.contains(str)) {
				tempList.add(str);
				wordBreak(i + 1, s, wordSet, tempList, output);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
