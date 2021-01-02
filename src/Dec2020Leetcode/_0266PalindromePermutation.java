package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0266PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
	}

	public static boolean canPermutePalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		int count = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			count+= entry.getValue()%2;
			if(count>1)
				return false;
		}
		return true;
	}
}
