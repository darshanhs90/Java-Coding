package April2021Leetcode;

import java.util.HashMap;

public class _0290WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> pMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();
		String[] sArr = s.split(" ");
		if (pattern.length() != sArr.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			char patternChar = pattern.charAt(i);
			String str = sArr[i];

			if (pMap.containsKey(patternChar) && !pMap.get(patternChar).equals(str))
				return false;

			if (sMap.containsKey(str) && sMap.get(str) != patternChar)
				return false;

			pMap.put(patternChar, str);
			sMap.put(str, patternChar);
		}
		return true;
	}
}
