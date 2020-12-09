package Nov2020_FBPrep;

import java.util.HashMap;

public class _010MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "b"));
		System.out.println(minWindow("aab", "aab"));
	}

	public static String minWindow(String s, String t) {
		if (t.length() == 0 || s.length() == 0)
			return "";
		HashMap<Character, Integer> requiredCharMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> wordCountMap = new HashMap<Character, Integer>();
		int leftIndex = 0, rightIndex = 0;
		int currCount = 0;

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			requiredCharMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		int requiredCount = requiredCharMap.size();

		int[] ans = { -1, 0, 0 };
		while (rightIndex < s.length()) {
			char currChar = s.charAt(rightIndex);
			wordCountMap.compute(currChar, (k, v) -> v == null ? 1 : v + 1);
			if (requiredCharMap.containsKey(currChar) && wordCountMap.get(currChar).intValue() == requiredCharMap.get(currChar).intValue()) {
				currCount++;
			}

			// move leftPtr until currcount == requiredCount
			while (leftIndex <= rightIndex && currCount == requiredCount) {
				char currLeftChar = s.charAt(leftIndex);
				if (ans[0] == -1 || rightIndex - leftIndex + 1 < ans[0]) {
					ans[0] = rightIndex - leftIndex + 1;
					ans[1] = leftIndex;
					ans[2] = rightIndex;
				}

				wordCountMap.computeIfPresent(currLeftChar, (k, v) -> v - 1);
				if (requiredCharMap.containsKey(currLeftChar)
						&& wordCountMap.get(currLeftChar).intValue() < requiredCharMap.get(currLeftChar).intValue()) {
					currCount--;
				}
				leftIndex++;
			}
			rightIndex++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
