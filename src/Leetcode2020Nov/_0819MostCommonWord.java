package Leetcode2020Nov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _0819MostCommonWord {
	public static void main(String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
		System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] { "a" }));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.replace(',', ' ');
		paragraph = paragraph.replace('!', ' ');
		paragraph = paragraph.replace('?', ' ');
		paragraph = paragraph.replace('\'', ' ');
		paragraph = paragraph.replace(';', ' ');
		paragraph = paragraph.replace('.', ' ');
		Set<String> bannedWords = new HashSet<String>();
		for (int i = 0; i < banned.length; i++) {
			bannedWords.add(banned[i].toLowerCase());
		}
		System.out.println(paragraph);
		String[] allWords = paragraph.split(" ");
		int maxCount = 0;
		String maxCountWord = "";
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i].trim().length() > 0) {
				String word = allWords[i].toLowerCase();
				if (!bannedWords.contains(word)) {
					if (countMap.containsKey(word)) {
						int currCount = countMap.get(word);
						countMap.put(word, currCount + 1);
						if (currCount + 1 > maxCount) {
							maxCount = currCount;
							maxCountWord = word;
						}
					} else {
						int currCount = 0;
						countMap.put(word, currCount + 1);
						if (currCount + 1 > maxCount) {
							maxCount = currCount;
							maxCountWord = word;
						}
					}
				}
			}
		}
		return maxCountWord;
	}
}
