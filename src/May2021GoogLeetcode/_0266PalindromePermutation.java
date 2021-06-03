package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _0266PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
	}

	public static boolean canPermutePalindrome(String s) {
		if (s == null || s.length() < 2)
			return true;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		boolean singleElementFound = false;
		boolean evenLength = s.length() % 2 == 0;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				if (evenLength || singleElementFound)
					return false;
				singleElementFound = true;
			}
		}
		return true;
	}
}
