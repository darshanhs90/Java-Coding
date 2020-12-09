package Nov2020_FBPrep;

public class _058LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("ac"));
		System.out.println(longestPalindrome("bb"));
	}

	static int maxLength;
	static String maxLengthString;

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		maxLength = 1;
		maxLengthString = s.charAt(0) + "";
		for (int i = 0; i < s.length() - 1; i++) {
			isPalindrome(s, i, i);
			isPalindrome(s, i, i + 1);
		}

		return maxLengthString;
	}

	public static void isPalindrome(String s, int left, int right) {
		int leftPtr = left;
		int rightPtr = right;
		int count = 0;
		while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			count++;
		}
		String str = "";
		if (leftPtr == rightPtr) {
			str = s.substring(leftPtr - count + 1, rightPtr + count);
		} else {
			str = s.substring(leftPtr - count + 1, rightPtr + count);
		}
		if (str.length() > maxLength) {
			maxLength = str.length();
			maxLengthString = str;
		}
	}
}
