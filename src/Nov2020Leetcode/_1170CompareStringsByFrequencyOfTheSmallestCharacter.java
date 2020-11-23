package Nov2020Leetcode;

import java.util.Arrays;

public class _1170CompareStringsByFrequencyOfTheSmallestCharacter {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(numSmallerByFrequency(new String[] { "cbd" }, new String[] { "zaaaz" })));
		System.out.println(Arrays.toString(
				numSmallerByFrequency(new String[] { "bbb", "cc" }, new String[] { "a", "aa", "aaa", "aaaa" })));
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] wordCount = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			wordCount[i] = getFValue(words[i]);
		}
		Arrays.parallelSort(wordCount);
		int[] output = new int[queries.length];
		for (int i = 0; i < output.length; i++) {
			int fVal = getFValue(queries[i]);
			int count = 0;
			for (int j = wordCount.length - 1; j >= 0; j--) {
				if (wordCount[j] > fVal) {
					count++;
				} else {
					break;
				}
			}
			output[i] = count;
		}
		return output;
	}

	public static int getFValue(String word) {
		char minCharacter = word.charAt(0);
		int count = 1;
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == minCharacter)
				count++;
			else if (c < minCharacter) {
				minCharacter = c;
				count = 1;
			}
		}
		return count;
	}

}
