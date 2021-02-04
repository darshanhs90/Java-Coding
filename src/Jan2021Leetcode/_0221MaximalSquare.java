package Jan2021Leetcode;

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
		int maxVal = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0 || matrix[i][j] == '0') {
					sum[i][j] = matrix[i][j] - '0';
				} else {
					sum[i][j] = Math.min(sum[i - 1][j], Math.min(sum[i - 1][j - 1], sum[i][j - 1])) + 1;
				}
				maxVal = Math.max(maxVal, sum[i][j]);
			}
		}
		return maxVal * maxVal;
	}
}
