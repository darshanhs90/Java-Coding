package Dec2020Leetcode;

import java.util.HashMap;

public class _0243ShortestWordDistance {

	public static void main(String[] args) {
		System.out.println(shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
				"coding", "practice"));
		System.out.println(shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes",
				"coding"));
	}

	public static int shortestDistance(String[] words, String word1, String word2) {
		int minDiff = words.length - 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
			if (map.containsKey(word1) && map.containsKey(word2)) {
				minDiff = Math.min(minDiff, Math.abs(map.get(word1) - map.get(word2)));
			}
		}
		return minDiff;
	}

}
