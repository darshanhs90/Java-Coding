package Jan2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0395LongestSubstringWithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb", 3));
		System.out.println(longestSubstring("ababbc", 2));
	}

	public static int longestSubstring(String s, int k) {
		if (s.length() == 0 || k == 0)
			return 0;

		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				map.compute(c, (key, val) -> val == null ? 1 : val + 1);
				if (isValidMap(map, k)) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return max;
	}

	public static boolean isValidMap(HashMap<Character, Integer> map, int k) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue().intValue() < k)
				return false;
		}
		return true;
	}
}
