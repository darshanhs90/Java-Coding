package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Map;

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
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int i = 0; i < licensePlate.length(); i++) {
			char c = licensePlate.charAt(i);
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				charCountMap.compute(Character.toLowerCase(c), (k, v) -> v == null ? 1 : v + 1);
			}
		}
		int minLength = Integer.MAX_VALUE;
		String out = "";
		for (int i = 0; i < words.length; i++) {
			HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				wordMap.compute(Character.toLowerCase(c), (k, v) -> v == null ? 1 : v + 1);
			}

			if (checkEquals(charCountMap, wordMap)) {
				if (word.length() < minLength) {
					out = word;
					minLength = word.length();
				}
			}
		}
		return out;
	}

	public static boolean checkEquals(HashMap<Character, Integer> wordMap1, HashMap<Character, Integer> wordMap2) {
		for (Map.Entry<Character, Integer> entry : wordMap1.entrySet()) {
			if (wordMap2.containsKey(entry.getKey()) && wordMap2.get(entry.getKey()) >= entry.getValue())
				continue;
			return false;
		}
		return true;
	}
}
