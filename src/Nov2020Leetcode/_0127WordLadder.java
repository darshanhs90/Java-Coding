package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0127WordLadder {

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog",
				new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

		System.out.println(
				ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

		System.out.println(ladderLength("a", "c", new ArrayList<String>(Arrays.asList("a", "b", "c"))));
	}

	static int minCount = Integer.MAX_VALUE;

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		minCount = Integer.MAX_VALUE;
		ladderLengthNew(beginWord, endWord, wordList, 0);
		return minCount == Integer.MAX_VALUE ? 0 : minCount;
	}

	public static void ladderLengthNew(String beginWord, String endWord, List<String> wordList, int count) {
		if (beginWord.contentEquals(endWord)) {
			minCount = Math.min(minCount, count + 1);
			return;
		}

		if (!wordList.contains(endWord))
			return;

		for (int i = 0; i < wordList.size(); i++) {
			String currWord = wordList.get(i);
			if (currWord.length() == beginWord.length() && !beginWord.contentEquals(currWord)
					&& isDiff(beginWord, currWord)) {
				wordList.remove(currWord);
				ladderLengthNew(currWord, endWord, wordList, count + 1);
				wordList.add(currWord);
			}
		}
	}

	public static boolean isDiff(String beginWord, String endWord) {
		int diffCount = 0;
		for (int i = 0; i < beginWord.length(); i++) {
			if (beginWord.charAt(i) != endWord.charAt(i))
				diffCount++;
			if (diffCount > 1)
				return false;
		}
		return diffCount <= 1;
	}
}
