package May2021GoogLeetcode;

import java.util.HashMap;

public class _0567PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length())
			return false;

		HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			s1Map.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			char c = s2.charAt(i);
			if (s1Map.containsKey(c) && checkPermutation(i, s1Map, s1, s2)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkPermutation(int index, HashMap<Character, Integer> s1Map, String s1, String s2) {
		HashMap<Character, Integer> s2Map = new HashMap<Character, Integer>();
		for (int i = index; i < index + s1.length() && i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!s1Map.containsKey(c) || s2Map.containsKey(c) && s2Map.get(c) >= s1Map.get(c))
				return false;
			s2Map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		return true;
	}
}
