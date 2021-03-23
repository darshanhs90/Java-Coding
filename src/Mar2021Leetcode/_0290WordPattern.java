package Mar2021Leetcode;

import java.util.HashMap;

public class _0290WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		String[] strArr = s.split(" ");
		if (strArr.length != pattern.length())
			return false;

		HashMap<Character, String> patternMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();

		for (int i = 0; i < strArr.length; i++) {
			char c = pattern.charAt(i);
			String str = strArr[i];

			if (patternMap.containsKey(c) && !patternMap.get(c).equals(str))
				return false;

			if (sMap.containsKey(str) && sMap.get(str) != c)
				return false;
			patternMap.put(c, str);
			sMap.put(str, c);
		}
		return true;
	}
}
