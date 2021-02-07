package Jan2021Leetcode;

public class _0115DistinctSubsequences {
	// https://www.youtube.com/watch?v=NR9lLQnFjWc
	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
		System.out.println(numDistinct("babgbag", "bag"));
	}

	public static int numDistinct(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return 0;

		int[][] dp = new int[t.length() + 1][s.length() + 1];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= t.length(); i++) {
			char tChar = t.charAt(i-1);
			for (int j = 1; j <= s.length(); j++) {
				if (tChar == s.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}

}
