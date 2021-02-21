package DropboxPrep;

import java.util.HashMap;

public class _0290WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> patternMap = new HashMap<Character, String>();
		HashMap<String, Character> stringMap = new HashMap<String, Character>();
		String strArr[] = s.split(" ");
		if (pattern.length() != strArr.length)
			return false;
		for (int i = 0; i < strArr.length; i++) {
			char c = pattern.charAt(i);
			String str = strArr[i];

			if (patternMap.containsKey(c) && !patternMap.get(c).equals(str))
				return false;

			if (stringMap.containsKey(str) && stringMap.get(str) != c)
				return false;

			patternMap.put(c, str);
			stringMap.put(str, c);
		}
		return true;
	}
}
