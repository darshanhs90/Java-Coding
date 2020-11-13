package Leetcode2020Nov;

import java.util.Arrays;
import java.util.HashSet;

public class _0720LongestWordInDictionary {
	public static void main(String[] args) {
		System.out.println(longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	public static String longestWord(String[] words) {
		Arrays.parallelSort(words);
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		int maxLength = 0;
		String maxWord = null;
		for (int i = words.length - 1; i >= 0; i--) {
			boolean wordMatches = true;
			String word = words[i];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < word.length() - 1; j++) {
				sb = sb.append(word.charAt(j));
				if (!set.contains(sb.toString())) {
					wordMatches = false;
				}
			}

			if (wordMatches && word.length() >= maxLength) {
				maxLength = word.length();
				maxWord = word;
			}
		}
		return maxWord;
	}
}
