package May2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0567PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
	}

	public static boolean checkInclusion(String s, String t) {
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			sMap.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		int left = 0, right = 0;
		while (right < t.length()) {
			char c = t.charAt(right);
			tMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			if (right >= s.length() - 1) {
				if (isMapEqual(sMap, tMap))
					return true;
				c = t.charAt(left);
				tMap.put(c, tMap.get(c) - 1);
				if (tMap.get(c) == 0)
					tMap.remove(c);
				left++;
			}
			right++;
		}
		return false;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
		if (sMap.size() != tMap.size())
			return false;

		for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
			char c = entry.getKey();
			int val = entry.getValue().intValue();

			if (!tMap.containsKey(c))
				return false;

			if (tMap.get(c).intValue() != val)
				return false;
		}
		return true;
	}
}
