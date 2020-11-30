package Nov2020_GoogPrep;

import java.util.HashMap;

public class _005LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("abbac"));
		System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring("abccb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int startIndex = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				startIndex = Math.max(map.get(c) + 1, startIndex);
			}
			map.put(c, i);
			max = Math.max(max, i - startIndex + 1);
		}
		return max;
	}
}
