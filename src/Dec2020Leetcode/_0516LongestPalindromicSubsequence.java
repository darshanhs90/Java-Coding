package Dec2020Leetcode;

public class _0516LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
		System.out.println(longestPalindromeSubseq("cbbd"));
		System.out.println(longestPalindromeSubseq("bab"));
	}

	public static int longestPalindromeSubseq(String s) {
		int left = 0, right = s.length() - 1;
		Integer[][] memo = new Integer[s.length()][s.length()];
		return longestPalindromeSubseq(left, right, s, memo);
	}

	public static int longestPalindromeSubseq(int left, int right, String s, Integer[][] memo) {
		if (memo[left][right] != null)
			return memo[left][right];
		if (left > right)
			return 0;
		if (left == right)
			return 1;
		char leftChar = s.charAt(left);
		char rightChar = s.charAt(right);
		if (leftChar == rightChar) {
			memo[left][right] = longestPalindromeSubseq(left + 1, right - 1, s, memo) + 2;
		} else {
			memo[left][right] = Math.max(longestPalindromeSubseq(left, right - 1, s, memo),
					longestPalindromeSubseq(left + 1, right, s, memo));
		}
		return memo[left][right];
	}

}
