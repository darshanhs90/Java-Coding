package Dec2020Leetcode;

import java.util.HashMap;

public class _0389FindTheDifference {

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
		System.out.println(findTheDifference("", "y"));
		System.out.println(findTheDifference("a", "aa"));
		System.out.println(findTheDifference("ae", "aea"));
	}

	public static char findTheDifference(String s, String t) {
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (sMap.containsKey(c) && sMap.get(c) > 0) {
				sMap.put(c, sMap.get(c) - 1);
			} else {
				return c;
			}
		}
		return 'a';
	}

}
