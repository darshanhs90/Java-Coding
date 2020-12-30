package Dec2020Leetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> wordSet = new HashSet<String>(wordDict);

		wordBreak(0, s, wordSet, new ArrayList<String>(), output);
		List<String> outputList = new ArrayList<String>();
		if (output.size() > 0) {
			for (List<String> list : output) {
				StringBuilder sb = new StringBuilder(list.get(0));
				for (int i = 1; i < list.size(); i++) {
					sb.append(" " + list.get(i));
				}
				outputList.add(sb.toString());
			}
			return outputList;
		}

		return new ArrayList<String>();
	}

	public static void wordBreak(int index, String s, HashSet<String> wordSet, List<String> list,
			List<List<String>> output) {
		if (index == s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (wordSet.contains(sb.toString())) {
				list.add(sb.toString());
				wordBreak(i + 1, s, wordSet, list, output);
				list.remove(list.size() - 1);
			}
		}
	}

}
