package Oct2023Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1941CheckIfAllCharactersHaveEqualNumberOfOccurrences {
	public static void main(String[] args) {
		System.out.println(areOccurrencesEqual("abacbc"));
		System.out.println(areOccurrencesEqual("aaabb"));
	}

	public static boolean areOccurrencesEqual(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			max = Math.max(max, map.get(c));
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != max) {
				return false;
			}
		}
		return true;
	}
}
