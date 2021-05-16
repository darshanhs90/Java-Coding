package May2021Leetcode;

public class _0221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[][] sum = new int[matrix.length][matrix[0].length];
		int max = 0;
		sum[0][0] = matrix[0][0] == '1' ? 1 : 0;
		max = Math.max(max, sum[0][0]);
		for (int i = 1; i < matrix.length; i++) {
			sum[i][0] = matrix[i][0] == '1' ? 1 : 0;
			max = Math.max(max, sum[i][0]);
		}
		for (int i = 1; i < matrix[0].length; i++) {
			sum[0][i] = matrix[0][i] == '1' ? 1 : 0;
			max = Math.max(max, sum[0][i]);
		}

		for (int i = 1; i < sum.length; i++) {
			for (int j = 1; j < sum[0].length; j++) {
				if (matrix[i][j] == '0') {
					sum[i][j] = 0;
				} else {
					sum[i][j] = Math.min(sum[i - 1][j - 1], Math.min(sum[i - 1][j], sum[i][j - 1])) + 1;
				}
				max = Math.max(max, sum[i][j]);
			}
		}
		return max * max;
	}
}
