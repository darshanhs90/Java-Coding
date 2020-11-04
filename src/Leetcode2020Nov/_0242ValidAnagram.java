package Leetcode2020Nov;

import java.util.HashMap;

public class _0242ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s != null && t == null || s == null && t != null || s.length() != t.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.computeIfPresent(c, (key, value) -> value + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				map.computeIfPresent(c, (key, value) -> value - 1);
			} else {
				return false;
			}
		}
		return true;
	}
}
