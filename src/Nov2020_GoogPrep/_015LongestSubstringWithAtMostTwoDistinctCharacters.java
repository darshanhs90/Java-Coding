package Nov2020_GoogPrep;

import java.util.Collections;
import java.util.HashMap;

public class _015LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		int left = 0, right = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (right < s.length()) {
			map.put(s.charAt(right), right);
			if (map.size() == 3) {
				int minIndex = Collections.min(map.values());
				map.remove(s.charAt(minIndex));
				left = minIndex + 1;
			}
			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}
}
