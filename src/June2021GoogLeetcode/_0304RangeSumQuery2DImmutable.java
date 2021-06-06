package June2021GoogLeetcode;

public class _0304RangeSumQuery2DImmutable {
	// https://www.youtube.com/watch?v=PwDqpOMwg6U
	public static void main(String[] args) {
		int[][] matrix = new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 },
				new int[] { 1, 2, 0, 1, 5 }, new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 } };
		NumMatrix nm = new NumMatrix(matrix);

		System.out.println(nm.sumRegion(2, 1, 4, 3));
		System.out.println(nm.sumRegion(1, 1, 2, 2));
		System.out.println(nm.sumRegion(1, 2, 2, 4));
	}

	static class NumMatrix {
		int[][] sum;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;
			sum = new int[matrix.length + 1][matrix[0].length + 1];
			for (int i = 1; i < sum.length; i++) {
				for (int j = 1; j < sum[0].length; j++) {
					sum[i][j] = -sum[i - 1][j - 1] + matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			row1++;
			col1++;
			row2++;
			col2++;

			return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];

		}
	}
}
