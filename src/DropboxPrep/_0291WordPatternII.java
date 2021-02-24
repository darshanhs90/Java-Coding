package DropboxPrep;

import java.util.HashMap;

public class _0291WordPatternII {

	public static void main(String[] args) {
		System.out.println(wordPatternMatch("abab", "redblueredblue"));
		System.out.println(wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(wordPatternMatch("abab", "asdasdasdasd"));
		System.out.println(wordPatternMatch("aabb", "xyzabcxzyabc"));
		System.out.println(wordPatternMatch("ab", "aa"));
	}

	static boolean solved;

	public static boolean wordPatternMatch(String pattern, String s) {
		if (pattern.length() > s.length())
			return false;
		solved = false;
		HashMap<Character, String> pMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();
		backtrack(0, 0, pattern, s, pMap, sMap);
		return solved;
	}

	public static void backtrack(int patternIndex, int stringIndex, String pattern, String s,
			HashMap<Character, String> pMap, HashMap<String, Character> sMap) {
		if (patternIndex == pattern.length() && stringIndex == s.length()) {
			solved = true;
			return;
		}

		if (solved)
			return;

		if (patternIndex == pattern.length() || stringIndex == s.length()) {
			return;
		}

		char c = pattern.charAt(patternIndex);
		String str = "";
		for (int i = stringIndex; i < s.length(); i++) {
			str += s.charAt(i);
			if (!pMap.containsKey(c) && !sMap.containsKey(str)) {
				pMap.put(c, str);
				sMap.put(str, c);
				backtrack(patternIndex + 1, i + 1, pattern, s, pMap, sMap);
				pMap.remove(c);
				sMap.remove(str);
			} else if (pMap.containsKey(c) && pMap.get(c).equals(str) && sMap.containsKey(str) && sMap.get(str) == c) {
				backtrack(patternIndex + 1, i + 1, pattern, s, pMap, sMap);
			} else {
				if (pMap.containsKey(c) && !pMap.get(c).startsWith(str)) {
					return;
				}
			}
		}
	}

}
