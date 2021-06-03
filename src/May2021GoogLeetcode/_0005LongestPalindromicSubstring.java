package May2021GoogLeetcode;

public class _0005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("ac"));
		System.out.println(longestPalindrome("amalayalam"));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		String maxString = "";
		for (int i = 0; i < s.length(); i++) {

			String str = palindrome(i, i, s);
			if (str.length() > maxString.length())
				maxString = str;
			if (i + 1 < s.length()) {
				str = palindrome(i, i + 1, s);
				if (str.length() > maxString.length())
					maxString = str;
			}
		}
		return maxString;
	}

	public static String palindrome(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

}
