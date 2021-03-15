package Feb2021Leetcode;

public class _0221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalSquare(char[][] matrix) {
		int maxVal = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < dp.length; i++) {
			if (matrix[i][0] == '1'){
				dp[i][0] = 1;
                maxVal = 1;
            }
		}

		for (int i = 0; i < dp[0].length; i++) {
			if (matrix[0][i] == '1'){
				dp[0][i] = 1;
                maxVal = 1;
            }
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					maxVal = Math.max(maxVal, dp[i][j]);
				}
			}
		}
		return maxVal*maxVal;
	}
}
