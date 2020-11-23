package Nov2020Leetcode;

import java.util.HashMap;

public class _0383RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				map.computeIfPresent(c, (k, v) -> v - 1);
			} else {
				return false;
			}
		}
		return true;
	}
}
