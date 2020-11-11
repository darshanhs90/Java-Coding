package Leetcode2020Nov;

import java.util.Arrays;

public class _0748ShortestCompletingWord {
	public static void main(String[] args) {
		System.out.println(shortestCompletingWord("1s3 PSt", new String[] { "step", "steps", "stripe", "stepple" }));
		System.out.println(shortestCompletingWord("1s3 456", new String[] { "looks", "pest", "stew", "show" }));
		System.out.println(shortestCompletingWord("Ah71752", new String[] { "suggest", "letter", "of", "husband",
				"easy", "education", "drug", "prevent", "writer", "old" }));
		System.out.println(shortestCompletingWord("OgEu755",
				new String[] { "enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus" }));
		System.out.println(shortestCompletingWord("iMSlpe4", new String[] { "claim", "consumer", "student", "camera",
				"public", "never", "wonder", "simple", "thought", "use" }));
	}

	public static String shortestCompletingWord(String licensePlate, String[] words) {
		int minLength = Integer.MAX_VALUE;
		String minLengthWord = "";
		licensePlate = licensePlate.toLowerCase();
		int[] sourceArr = new int[26];
		Arrays.fill(sourceArr, 0);
		for (int i = 0; i < licensePlate.length(); i++) {
			char c = licensePlate.charAt(i);
			if (c >= 97 && c <= 122) {
				sourceArr[c - 97]++;
			}
		}

		for (int i = 0; i < words.length; i++) {
			int[] wordArr = new int[26];
			String word = words[i];
			Arrays.fill(wordArr, 0);
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (c >= 97 && c <= 122) {
					wordArr[c - 97]++;
				}
			}

			boolean stringMatches = true;
			for (int j = 0; j < wordArr.length; j++) {
				if (sourceArr[j] != 0 && sourceArr[j] > wordArr[j]) {
					stringMatches = false;
					break;
				}
			}

			if (stringMatches && word.length() < minLength) {
				minLengthWord = word;
				minLength = minLengthWord.length();
			}

		}
		return minLengthWord;
	}
}
