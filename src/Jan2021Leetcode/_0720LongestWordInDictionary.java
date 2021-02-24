package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _0720LongestWordInDictionary {
	public static void main(String[] args) {
		System.out.println(longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	public static String longestWord(String[] words) {
		HashSet<String> set = new HashSet<String>();
		for (String str : words) {
			set.add(str);
		}

		Arrays.sort(words);
		int maxLength = 0;
		String maxWord = "";
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].length() >= maxLength && checkWord(words[i], set)) {
				maxLength = words[i].length();
				maxWord = words[i];
			}
		}
		return maxWord;
	}

	public static boolean checkWord(String word, HashSet<String> set) {
		if (word.length() == 0)
			return true;
		return set.contains(word) && checkWord(word.substring(0, word.length() - 1), set);
	}
}
