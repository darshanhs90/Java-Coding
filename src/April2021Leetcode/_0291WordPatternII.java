package April2021Leetcode;

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
		HashMap<Character, String> patternMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();
		return dfs(0, 0, pattern, s, patternMap, sMap);
	}

	public static boolean dfs(int patternIndex, int stringIndex, String pattern, String s,
			HashMap<Character, String> patternMap, HashMap<String, Character> sMap) {

		if (patternIndex == pattern.length() && stringIndex == s.length())
			return true;

		if (patternIndex >= pattern.length() || stringIndex >= s.length())
			return false;

		boolean out = false;
		char c = pattern.charAt(patternIndex);

		String str = "";
		for (int i = stringIndex; i < s.length(); i++) {
			str += s.charAt(stringIndex);

			if (patternMap.containsKey(c)) {
				if (!patternMap.get(c).equals(str)) {
					continue;
				} else {
					if (!sMap.containsKey(str) || sMap.get(str) != c) {
						continue;
					}
					if (dfs(patternIndex + 1, i + 1, pattern, s, patternMap, sMap))
						return true;
				}
			} else {
				if (sMap.containsKey(str)) {
					continue;
				}

				patternMap.put(c, str);
				sMap.put(str, c);

				if (!dfs(patternIndex + 1, i + 1, pattern, s, patternMap, sMap)) {
					patternMap.remove(c);
					sMap.remove(str);
				} else {
					return true;
				}

			}

		}
		return out;
	}

}
