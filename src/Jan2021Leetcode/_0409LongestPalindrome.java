package Jan2021Leetcode;

import java.util.HashMap;

public class _0409LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome("bb"));
		System.out.println(longestPalindrome("a"));
	}

	public static int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);

			if (map.get(c) == 2) {
				count += 2;
				map.remove(c);
			}
		}
		if (map.size() > 0)
			count += 1;

		return count;
	}

}
