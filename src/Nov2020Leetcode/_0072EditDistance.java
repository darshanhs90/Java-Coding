package Nov2020Leetcode;

public class _0072EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));
	}

	public static int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + 1;
				} else {
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
					}
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
