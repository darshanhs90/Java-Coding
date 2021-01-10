package Dec2020Leetcode;

import java.util.Arrays;

public class _1170CompareStringsByFrequencyOfTheSmallestCharacter {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(numSmallerByFrequency(new String[] { "cbd" }, new String[] { "zaaaz" })));
		System.out.println(Arrays.toString(
				numSmallerByFrequency(new String[] { "bbb", "cc" }, new String[] { "a", "aa", "aaa", "aaaa" })));
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] queriesNumbers = new int[queries.length];
		int[] wordsNumbers = new int[words.length];
		int[] output = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			queriesNumbers[i] = getFNumber(queries[i]);
		}

		for (int i = 0; i < words.length; i++) {
			wordsNumbers[i] = getFNumber(words[i]);
		}

		for (int i = 0; i < queries.length; i++) {
			int count = 0;
			for (int j = 0; j < wordsNumbers.length; j++) {
				if (queriesNumbers[i] < wordsNumbers[j])
					count++;
			}
			output[i] = count;
		}

		return output;
	}

	public static int getFNumber(String word) {
		if (word.length() == 0)
			return 0;
		char smallChar = word.charAt(0);
		int count = 1;
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c < smallChar) {
				smallChar = c;
				count = 1;
			} else if (c == smallChar)
				count++;
		}
		return count;
	}

}
