package Feb2021Leetcode;

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
		List<String> output = new ArrayList<String>();

		for (String word : words) {
			set.remove(word);
			if (canSplit(word, set)) {
				output.add(word);
			}
			set.add(word);
		}
		return output;
	}

	public static boolean canSplit(String word, HashSet<String> set) {
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

}
