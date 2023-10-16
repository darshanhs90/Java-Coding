package Oct2023Leetcode;

import java.util.HashMap;

public class _0205IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> sMap = new HashMap<Character, Character>();
		HashMap<Character, Character> tMap = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (sMap.containsKey(c1) && sMap.get(c1) != c2) {
				return false;
			}
			if (tMap.containsKey(c2) && tMap.get(c2) != c1) {
				return false;
			}
			sMap.put(c1, c2);
			tMap.put(c2, c1);
		}
		return true;
	}
}
