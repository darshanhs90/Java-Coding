package May2021PrepLeetcode;

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
			char c1 = s.charAt(i);
			map.compute(c1, (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			char c1 = t.charAt(i);
			if (!map.containsKey(c1))
				return false;
			map.put(c1, map.get(c1) - 1);
			if (map.get(c1) == 0)
				map.remove(c1);
		}

		return true;
	}
}
