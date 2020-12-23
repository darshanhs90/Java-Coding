package Dec2020Leetcode;

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
		int maxLength = 0;
		String output = "";
		for (int i = 0; i < s.length() - 1; i++) {
			String st = checkPalindrome(i, i, s);
			if (st.length() > maxLength) {
				maxLength = st.length();
				output = st;
			}
			String st1 = checkPalindrome(i, i + 1, s);
			if (st1.length() > maxLength) {
				maxLength = st1.length();
				output = st1;
			}
		}
		return output;
	}

	public static String checkPalindrome(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}

}
