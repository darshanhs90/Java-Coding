package Nov2020_UberPrep;

import java.util.HashMap;

public class _005MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		int left = 0, right = 0;
		int outputLength = s.length();
		String out = "";
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		int required = tMap.size();
		int currCount = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
				if (sMap.get(c).intValue() == tMap.get(c).intValue()) {
					currCount++;
				}

				while (left <= right && currCount == required) {
					if (outputLength >= right - left + 1) {
						outputLength = right - left + 1;
						out = s.substring(left, right + 1);
					}
					char leftChar = s.charAt(left);
					if (sMap.containsKey(leftChar) && sMap.get(leftChar).intValue() > 0) {
						sMap.put(leftChar, sMap.get(leftChar) - 1);
						if (sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
							currCount--;
						}
					}
					left++;
				}
			}
			right++;
		}
		return outputLength == Integer.MAX_VALUE ? "" : out;
	}
}
