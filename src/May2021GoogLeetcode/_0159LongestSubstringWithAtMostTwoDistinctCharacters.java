package May2021GoogLeetcode;

import java.util.HashMap;

public class _0159LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		int left = 0, right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);

			while (map.size() > 2) {
				c = s.charAt(left);
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					map.remove(c);

				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}

}
