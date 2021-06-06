package June2021GoogLeetcode;

public class _0221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[][] mat = new int[matrix.length][matrix[0].length];
		int max = 0;

		for (int i = 0; i < mat.length; i++) {
			mat[i][0] = matrix[i][0] == '1' ? 1 : 0;
			max = Math.max(max, mat[i][0]);
		}
		for (int i = 0; i < mat[0].length; i++) {
			mat[0][i] = matrix[0][i] == '1' ? 1 : 0;
			max = Math.max(max, mat[0][i]);
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (matrix[i][j] == '0') {
					mat[i][j] = 0;
				} else {
					mat[i][j] = 1 + Math.min(mat[i - 1][j], Math.min(mat[i - 1][j - 1], mat[i][j - 1]));
				}
				max = Math.max(max, mat[i][j]);
			}
		}
		return max * max;
	}
}
