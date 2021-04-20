package April2021PrepLeetcode;

import java.util.HashMap;

public class _0291WordPatternII {

	public static void main(String[] args) {
		System.out.println(wordPatternMatch("abab", "redblueredblue"));
		System.out.println(wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(wordPatternMatch("abab", "asdasdasdasd"));
		System.out.println(wordPatternMatch("aabb", "xyzabcxzyabc"));
		System.out.println(wordPatternMatch("ab", "aa"));
	}

	public static boolean wordPatternMatch(String pattern, String s) {
		HashMap<Character, String> pMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();
		return canMatch(0, 0, pattern, s, pMap, sMap);
	}

	public static boolean canMatch(int pIndex, int sIndex, String pattern, String s, HashMap<Character, String> pMap,
			HashMap<String, Character> sMap) {
		if (pIndex == pattern.length() && sIndex == s.length())
			return true;
		if (pIndex >= pattern.length() || sIndex >= s.length())
			return false;

		char c = pattern.charAt(pIndex);

		String str = "";
		for (int i = sIndex; i < s.length(); i++) {
			str += s.charAt(i);
			if (pMap.containsKey(c)) {
				if (!pMap.get(c).equals(str))
					continue;

				if (sMap.get(str) != c)
					continue;

				return canMatch(pIndex + 1, i + 1, pattern, s, pMap, sMap);
			} else {
				if (sMap.containsKey(str))
					continue;

				pMap.put(c, str);
				sMap.put(str, c);
				if (canMatch(pIndex + 1, i + 1, pattern, s, pMap, sMap))
					return true;
				pMap.remove(c);
				sMap.remove(str);
			}
		}
		return false;
	}

}
