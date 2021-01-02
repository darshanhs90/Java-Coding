package Dec2020Leetcode;

import java.util.HashMap;

public class _0290WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		String[] sArr = s.split(" ");
		if (pattern.length() != sArr.length)
			return false;

		HashMap<Character, String> pMap = new HashMap<Character, String>();
		HashMap<String, Character> sMap = new HashMap<String, Character>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String str = sArr[i];
			if (pMap.containsKey(c) && !pMap.get(c).equals(str))
				return false;
			pMap.put(c, str);

			if (sMap.containsKey(str) && sMap.get(str) != c)
				return false;
			sMap.put(str, c);
		}
		return true;
	}
}
