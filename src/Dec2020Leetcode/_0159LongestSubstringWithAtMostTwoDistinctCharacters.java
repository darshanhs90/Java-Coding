package Dec2020Leetcode;

import java.util.HashMap;

public class _0159LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0;
		int maxLength = 0;
		while (right < s.length()) {
			char currChar = s.charAt(right);
			if (map.containsKey(currChar)) {
				map.put(currChar, right);
			} else {
				if (map.size() == 2) {
					int index = right - 1;
					char c1 = s.charAt(index);
					while (index > left && s.charAt(index) == c1) {
						index--;
					}
					left = index + 1;
					map.remove(s.charAt(left - 1));
					map.put(currChar, right);
				} else {
					map.put(currChar, right);
				}
			}
			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}

}
