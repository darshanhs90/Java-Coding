package Nov2020_GoogPrep;

public class _059LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("ac"));
	}

	static String longestPalindrome;

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		longestPalindrome = "";
		for (int i = 0; i < s.length() - 1; i++) {
			findPalindrome(s, i, i);
			findPalindrome(s, i, i + 1);
		}
		return longestPalindrome;
	}

	public static void findPalindrome(String s, int left, int right) {
		String longestLocalPalindrome = "";
		while (left >= 0 && right < s.length() && left <= right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (leftChar != rightChar) {
				break;
			}

			longestLocalPalindrome = s.substring(left, right + 1);
			left--;
			right++;
		}
		if (longestLocalPalindrome.length() > longestPalindrome.length())
			longestPalindrome = longestLocalPalindrome;
	}

}
