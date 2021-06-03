package May2021GoogLeetcode;

public class _0221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int maxVal = 0;
		int[][] sq = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == '1') {
				maxVal = 1;
				sq[i][0] = 1;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1') {
				maxVal = 1;
				sq[0][i] = 1;
			}
		}

		for (int i = 1; i < sq.length; i++) {
			for (int j = 1; j < sq[0].length; j++) {
				if (matrix[i][j] == '1') {
					sq[i][j] = Math.min(sq[i - 1][j - 1], Math.min(sq[i - 1][j], sq[i][j - 1])) + 1;
				}
				maxVal = Math.max(maxVal, sq[i][j]);
			}
		}
		return maxVal * maxVal;
	}
}
