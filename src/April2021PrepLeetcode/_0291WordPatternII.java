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
		HashMap<Character, String> patternMap = new HashMap<Character, String>();
		HashMap<String, Character> stringMap = new HashMap<String, Character>();
		return dfs(0, 0, pattern, s, patternMap, stringMap);
	}

	public static boolean dfs(int patternIndex, int stringIndex, String pattern, String s,
			HashMap<Character, String> patternMap, HashMap<String, Character> stringMap) {
		if (patternIndex == pattern.length() && stringIndex == s.length())
			return true;

		if (patternIndex >= pattern.length() || stringIndex >= s.length())
			return false;

		char c = pattern.charAt(patternIndex);

		String str = "";

		for (int i = stringIndex; i < s.length(); i++) {
			str += s.charAt(i);

			if (patternMap.containsKey(c)) {
				if (!patternMap.get(c).equals(str))
					continue;

				if (stringMap.containsKey(str) && stringMap.get(str) != c)
					continue;

				return dfs(patternIndex + 1, i + 1, pattern, s, patternMap, stringMap);
			} else {
				if (stringMap.containsKey(str))
					continue;

				patternMap.put(c, str);
				stringMap.put(str, c);
				if (dfs(patternIndex + 1, i + 1, pattern, s, patternMap, stringMap)) {
					return true;
				}
				patternMap.remove(c);
				stringMap.remove(str);
			}
		}
		return false;
	}

}
