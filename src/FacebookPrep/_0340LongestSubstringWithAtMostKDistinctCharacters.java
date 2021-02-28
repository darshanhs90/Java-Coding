package FacebookPrep;

import java.util.HashMap;

public class _0340LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		if (s == null || s.length() == 0 || k == 0)
			return 0;
		int left = 0, right = 0;
		int maxLength = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			charMap.compute(c, (key, val) -> val == null ? 1 : val + 1);

			while (charMap.size() > k) {
				char c1 = s.charAt(left);
				charMap.put(c1, charMap.get(c1) - 1);

				if (charMap.get(c1) == 0)
					charMap.remove(c1);
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}
}
