package Jan2021Leetcode;

import java.util.HashMap;

public class _0567PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			s1Map.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			char c = s2.charAt(i);
			if (s1Map.containsKey(c) && checkString(i, s1, s2, s1Map)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkString(int index, String s1, String s2, HashMap<Character, Integer> s1Map) {
		HashMap<Character, Integer> s2Map = new HashMap<Character, Integer>();
		for (int i = index; i < index + s1.length(); i++) {
			char c = s2.charAt(i);
			if (s1Map.containsKey(c)) {
				s2Map.compute(c, (k, v) -> v == null ? 1 : v + 1);
				if (s2Map.get(c).intValue() > s1Map.get(c).intValue())
					return false;
			} else {
				return false;
			}
		}
		return true;
	}

}
