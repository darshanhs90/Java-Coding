package Dec2020Leetcode;

import java.util.HashMap;

public class _0383RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			magazineMap.compute(magazine.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			if (magazineMap.containsKey(c) && magazineMap.get(c) > 0) {
				magazineMap.put(c, magazineMap.get(c) - 1);
			} else {
				return false;
			}
		}
		return true;
	}
}
