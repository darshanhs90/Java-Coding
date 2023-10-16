package Oct2023Leetcode;

import java.util.HashMap;

public class _0567PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
		System.out.println(checkInclusion("adc", "dcda"));
	}

	public static boolean checkInclusion(String s, String t) {
		if (s.length() > t.length())
			return false;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			sMap.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i <= t.length() - s.length(); i++) {
			if (checkSubstring(sMap, i, s, t))
				return true;
		}
		return false;
	}

	public static boolean checkSubstring(HashMap<Character, Integer> sMap, int startIndex, String s, String t) {
		HashMap<Character, Integer> sMapCopy = new HashMap<Character, Integer>(sMap);
		for (int i = startIndex; i < startIndex + s.length(); i++) {
			char c = t.charAt(i);
			if (!sMapCopy.containsKey(c) || sMapCopy.get(c) <= 0) {
				return false;
			}
			sMapCopy.put(c, sMapCopy.get(c) - 1);
		}
		return true;
	}
}
