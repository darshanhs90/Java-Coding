package Leetcode2020Nov;

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
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> reverseMap = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (map.containsKey(sChar) && map.get(sChar) != tChar)
				return false;
			else
				map.put(sChar, tChar);
			if (reverseMap.containsKey(tChar) && reverseMap.get(tChar) != sChar)
				return false;
			else
				reverseMap.put(tChar, sChar);

		}
		return true;
	}
}
