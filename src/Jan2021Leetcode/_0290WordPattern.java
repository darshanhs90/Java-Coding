package Jan2021Leetcode;

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
		String sArr[] = s.split(" ");
		if (pattern.length() != sArr.length)
			return false;

		for (int i = 0; i < sArr.length; i++) {
			char c = pattern.charAt(i);
			String str = sArr[i];
			if (patternMap.containsKey(c) && !patternMap.get(c).equals(str))
				return false;
			patternMap.put(c, str);

			if (stringMap.containsKey(str) && stringMap.get(str) != c)
				return false;
			stringMap.put(str, c);
		}
		return true;
	}
}
