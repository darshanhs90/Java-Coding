package Dec2020Leetcode;

import java.util.HashMap;

public class _0076MinimumWindowSubstring {

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
		int count = 0;
		int maxLength = Integer.MAX_VALUE;
		String maxString = "";
		int required = tMap.size();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);

				if (sMap.get(c).intValue() == tMap.get(c).intValue()) {
					count++;
				}

				while (count == required && left < s.length()) {
					if (right - left + 1 < maxLength) {
						maxLength = right - left + 1;
						maxString = s.substring(left, right + 1);
					}
					char leftChar = s.charAt(left);
					if (tMap.containsKey(leftChar)) {
						sMap.compute(leftChar, (k, v) -> v == null ? 0 : v - 1);

						if (sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue())
							count--;
					}
					left++;
				}
			}
			right++;
		}
		return maxString;
	}
}
