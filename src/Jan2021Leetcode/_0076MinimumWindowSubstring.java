package Jan2021Leetcode;

import java.util.HashMap;
import java.util.Map;

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

		int minStringLen = Integer.MAX_VALUE;
		String maxString = "";
		int left = 0, right = 0;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);

				if (mapMatches(sMap, tMap)) {
					while (mapMatches(sMap, tMap)) {
						String currStr = s.substring(left, right + 1);
						if (currStr.length() < minStringLen) {
							maxString = currStr;
							minStringLen = currStr.length();
						}
						char leftChar = s.charAt(left);
						if (tMap.containsKey(leftChar)) {
							sMap.put(leftChar, sMap.get(leftChar) - 1);
							if (sMap.get(leftChar).intValue() == 0)
								sMap.remove(leftChar);
						}
						left++;
					}
				}

			}
			right++;
		}

		return maxString;
	}

	public static boolean mapMatches(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
		if (sMap.size() != tMap.size())
			return false;

		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			char key = entry.getKey();
			if (!sMap.containsKey(key) || sMap.get(key).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
