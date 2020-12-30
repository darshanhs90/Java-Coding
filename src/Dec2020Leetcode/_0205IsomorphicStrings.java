package Dec2020Leetcode;

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
			char sC = s.charAt(i);
			char tC = t.charAt(i);
			if (sMap.containsKey(sC) && sMap.get(sC) != tC)
				return false;
			sMap.put(sC, tC);

			if (tMap.containsKey(tC) && tMap.get(tC) != sC)
				return false;
			tMap.put(tC, sC);
		}
		return true;
	}
}
