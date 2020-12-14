package Nov2020_GoogPrep;

import java.util.HashMap;

public class _073IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "ba"));
		System.out.println(isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> sToTMap = new HashMap<Character, Character>();
		HashMap<Character, Character> tToSMap = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (sToTMap.containsKey(sChar) && sToTMap.get(sChar) != tChar)
				return false;
			sToTMap.put(sChar, tChar);

			if (tToSMap.containsKey(tChar) && tToSMap.get(tChar) != sChar)
				return false;
			tToSMap.put(tChar, sChar);
		}
		return true;
	}
}
