package Mar2021Leetcode;

import java.util.HashMap;

public class _0242ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) < 1)
				return false;
			map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
		}
		return true;
	}
}
