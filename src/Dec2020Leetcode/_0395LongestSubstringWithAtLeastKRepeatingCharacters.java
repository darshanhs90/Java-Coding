package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0395LongestSubstringWithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb", 3));
		System.out.println(longestSubstring("ababbc", 2));
	}

	public static int longestSubstring(String s, int k) {
		if (k == 1)
			return s.length();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {

			int start = i;
			int end = i;
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			while (end < s.length()) {
				char c = s.charAt(end);
				map.compute(c, (key, val) -> val == null ? 1 : val + 1);
				if (isValidMap(map, k)) {
					max = Math.max(max, end - start + 1);
				}
				end++;
			}
		}
		return max;
	}

	public static boolean isValidMap(HashMap<Character, Integer> map, int k) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() < k)
				return false;
		}
		return true;
	}
}
