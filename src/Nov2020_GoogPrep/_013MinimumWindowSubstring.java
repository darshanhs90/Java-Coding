package Nov2020_GoogPrep;

import java.util.HashMap;

public class _013MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}

	public static String minWindow(String s, String t) {
		if (s.length() < t.length() || t.length() == 0 || s.length() == 0)
			return "";

		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		String out = null;
		int required = tMap.size();
		int left = 0, right = 0;
		int count = 0;
		HashMap<Character, Integer> wordCountMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				wordCountMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
				if (wordCountMap.get(c).intValue() == tMap.get(c).intValue()) {
					count++;
				}
			}

			if (count == required) {
				while (count == required) {
					if (out == null || s.substring(left, right + 1).length() < out.length()) {
						out = s.substring(left, right + 1);
					}
					char c1 = s.charAt(left);
					if (wordCountMap.containsKey(c1)) {
						wordCountMap.put(c1, wordCountMap.get(c1) - 1);
						if (wordCountMap.get(c1).intValue() < tMap.get(c1).intValue())
							count--;
					}
					left++;
				}
				while (left <= right && !tMap.containsKey(s.charAt(left))) {
					left++;
				}
			}
			right++;
		}
		return out == null ? "" : out;
	}
}
