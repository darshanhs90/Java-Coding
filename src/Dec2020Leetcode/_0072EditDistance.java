package Dec2020Leetcode;

public class _0072EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));
	}

	public static int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = Math.min(dp[i - 1][j - 1] - 1, Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
