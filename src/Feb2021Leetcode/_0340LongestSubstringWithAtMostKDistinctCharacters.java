package Feb2021Leetcode;

import java.util.HashMap;

public class _0340LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int right = 0, left = 0;
		int maxLength = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			map.compute(c, (key, val) -> val == null ? 1 : val + 1);

			while (map.size() > k) {
				char c1 = s.charAt(left);
				map.put(c1, map.get(c1) - 1);

				if (map.get(c1) == 0)
					map.remove(c1);
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}

		return maxLength;
	}
}
