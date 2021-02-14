package Jan2021Leetcode;

import java.util.HashMap;

public class _0159LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int left = 0, right = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
			while(left<s.length() && map.size() > 2)
			{
				char c1 = s.charAt(left);
				map.compute(c1, (k, v) -> v == null ? 1 : v - 1);
				if(map.get(c1) == 0)
					map.remove(c1);
				left++;
			}
			maxLength = Math.max(maxLength, right-left+1);
			right++;
		}
		return maxLength;
	}

}
