package Nov2020_FBPrep;

public class _063RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 },
				new int[] { 1, 2, 0, 1, 5 }, new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 } };

		NumMatrix obj = new NumMatrix(matrix);
		System.out.println(obj.sumRegion(2, 1, 4, 3));
		System.out.println(obj.sumRegion(1, 1, 2, 2));
		System.out.println(obj.sumRegion(1, 2, 2, 4));
	}

	static class NumMatrix {
		int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0) {
				return;
			}
			dp = new int[matrix.length + 1][matrix[0].length + 1];
			for (int i = 0; i < dp[0].length; i++) {
				dp[0][i] = 0;
			}
			for (int i = 0; i < dp.length; i++) {
				dp[i][0] = 0;
			}

			for (int i = 1; i < dp.length; i++) {
				dp[i][1] = dp[i - 1][1] + matrix[i - 1][0];
			}

			for (int i = 1; i < dp[0].length; i++) {
				dp[1][i] = dp[1][i - 1] + matrix[0][i - 1];
			}

			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[0].length; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int r1 = Math.min(row1, row2);
			int c1 = Math.min(col1, col2);
			int r2 = Math.max(row1, row2);
			int c2 = Math.max(col1, col2);

			return dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
		}
	}
}
