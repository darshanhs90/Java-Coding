package Nov2020_FBPrep;

import java.util.HashMap;

public class _019LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
		System.out.println(lengthOfLongestSubstringKDistinct("ccaabbb", 2));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s.length() == 0 || k == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int leftIndex = 0, rightIndex = 0;
		int currCount = 0;
		int length = 0;
		while (rightIndex < s.length()) {
			char c = s.charAt(rightIndex);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				currCount++;
				while (leftIndex <= rightIndex && currCount > k) {
					char currChar = s.charAt(leftIndex);
					if (map.get(currChar) == 1) {
						map.remove(currChar);
						currCount--;
					} else {
						map.put(currChar, map.get(currChar) - 1);
					}
					leftIndex++;
				}
			}
			if (currCount <= k) {
				length = Math.max(length, rightIndex - leftIndex + 1);
			}
			rightIndex++;
		}
		return length;
	}
}
