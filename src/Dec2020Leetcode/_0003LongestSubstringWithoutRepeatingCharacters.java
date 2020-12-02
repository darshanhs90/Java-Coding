package Dec2020Leetcode;

import java.util.HashMap;

public class _0003LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println(lengthOfLongestSubstring("abac"));
		System.out.println(lengthOfLongestSubstring("tmmzuxt"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int startIndex = 0;
		int maxVal = 0;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charMap.containsKey(c)) {
				startIndex = Math.max(charMap.get(c) + 1, startIndex);
			}
			charMap.put(c, i);
			maxVal = Math.max(maxVal, i - startIndex + 1);
		}
		return maxVal;
	}
}
