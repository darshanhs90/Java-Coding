package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0472ConcatenatedWords {

	public static void main(String[] args) {
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog",
				"dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));
		System.out.println(findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));
	}

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		HashSet<String> set = new HashSet<String>(new ArrayList<String>(Arrays.asList(words)));
		List<String> list = new ArrayList<String>();
		if (words == null || words.length < 3)
			return list;
		for (int i = 0; i < words.length; i++) {
			String currWord = words[i];
			set.remove(currWord);
			dfs(0, currWord, set, list);
			set.add(currWord);
		}
		return list;
	}

	public static void dfs(int index, String currWord, HashSet<String> set, List<String> output) {
		if (index == currWord.length()) {
			output.add(currWord);
			return;
		}

		for (int i = index + 1; i <= currWord.length(); i++) {
			String subStr = currWord.substring(index, i);
			if (set.contains(subStr)) {
				dfs(i, currWord, set, output);
			}
		}
	}

}
