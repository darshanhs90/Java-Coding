package Oct2023Leetcode;

import java.util.HashMap;

public class _0003LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("abcdefgh"));
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring("abbab"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0, prevIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			} else {
				prevIndex = Math.max(prevIndex, map.get(c) + 1);
				map.put(c, i);
			}
			max = Math.max(max, i - prevIndex + 1);
		}
		return max;
	}
}
