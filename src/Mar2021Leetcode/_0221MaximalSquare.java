package Mar2021Leetcode;

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

		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
		for (int i = 0; i < rows; i++) {
			sum[i][0] = matrix[i][0] == '0' ? 0 : 1;
			max = Math.max(max, sum[i][0]);
		}

		for (int i = 0; i < cols; i++) {
			sum[0][i] = matrix[0][i] == '0' ? 0 : 1;
			max = Math.max(max, sum[0][i]);
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == '1') {
					sum[i][j] = Math.min(sum[i - 1][j - 1], Math.min(sum[i - 1][j], sum[i][j - 1])) + 1;
				}

				max = Math.max(max, sum[i][j]);
			}
		}
		return max * max;
	}
}
