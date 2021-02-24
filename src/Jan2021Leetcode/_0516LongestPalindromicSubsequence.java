package Jan2021Leetcode;

public class _0516LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
		System.out.println(longestPalindromeSubseq("cbbd"));
		System.out.println(longestPalindromeSubseq("bab"));
	}

	public static int longestPalindromeSubseq(String s) {
		return longestPalindromeSubseq(0, s.length() - 1, s);
	}

	public static int longestPalindromeSubseq(int left, int right, String s) {
		if (left > right)
			return 0;
		if (left == right)
			return 1;

		if (s.charAt(left) == s.charAt(right)) {
			return 2 + longestPalindromeSubseq(left + 1, right - 1, s);
		} else {
			return Math.max(longestPalindromeSubseq(left + 1, right, s), longestPalindromeSubseq(left, right - 1, s));
		}
	}

}
