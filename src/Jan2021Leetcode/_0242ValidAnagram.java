package Jan2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0242ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			sMap.compute(c1, (k, v) -> v == null ? 1 : v + 1);
			tMap.compute(c2, (k, v) -> v == null ? 1 : v + 1);
		}

		for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
			if (!tMap.containsKey(entry.getKey()) || tMap.get(entry.getKey()).intValue() != entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
