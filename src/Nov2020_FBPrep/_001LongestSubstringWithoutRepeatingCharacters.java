package Nov2020_FBPrep;

import java.util.HashMap;

public class _001LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("a"));
		System.out.println(lengthOfLongestSubstring("abcba"));
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println(lengthOfLongestSubstring("tmmzuxt"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxLength = 0;
		int startIndex = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				startIndex = Math.max(startIndex, map.get(c) + 1);
				maxLength = Math.max(maxLength, i - startIndex+1);
				map.put(c, i);
			} else {
				map.put(c, i);
				maxLength = Math.max(maxLength, i - startIndex + 1);
			}
		}
		return maxLength;
	}
}
