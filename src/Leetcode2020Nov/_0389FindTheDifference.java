package Leetcode2020Nov;

import java.util.HashMap;

public class _0389FindTheDifference {

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
		System.out.println(findTheDifference("", "y"));
		System.out.println(findTheDifference("a", "aa"));
		System.out.println(findTheDifference("ae", "aea"));
	}

	public static char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.computeIfPresent(c, (k, v) -> v + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				map.computeIfPresent(c, (k, v) -> v - 1);
			} else {
				return c;
			}
		}
		return ' ';
	}
}
