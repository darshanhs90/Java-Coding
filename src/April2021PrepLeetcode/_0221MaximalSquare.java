package April2021PrepLeetcode;

public class _0221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == '1')
				maxLength = 1;
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1')
				maxLength = 1;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					int val1 = matrix[i - 1][j - 1] - '0';
					int val2 = matrix[i - 1][j] - '0';
					int val3 = matrix[i][j - 1] - '0';

					int val = Math.min(val1, Math.min(val2, val3)) + 1;
					matrix[i][j] = (char) (val + '0');
					maxLength = Math.max(maxLength, val);
				}
			}
		}
		return maxLength * maxLength;
	}
}
