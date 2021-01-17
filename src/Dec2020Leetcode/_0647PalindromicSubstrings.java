package Dec2020Leetcode;

import java.util.HashMap;

public class _0647PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

	public static int countSubstrings(String s) {
		HashMap<String, Boolean> palindromeMap = new HashMap<String, Boolean>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i);
			for (int j = 0; j < str.length(); j++) {
				String subString = str.substring(0, j + 1);
				if (isPalindrome(subString, palindromeMap)) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isPalindrome(String s, HashMap<String, Boolean> palindromeMap) {
		if (palindromeMap.containsKey(s)) {
			return palindromeMap.get(s);
		}
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				palindromeMap.put(s, false);
				return false;
			}
			left++;
			right--;
		}
		palindromeMap.put(s, true);
		return true;
	}
}
