package Nov2020Leetcode;

import java.util.Arrays;

public class _0304RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 },
				new int[] { 1, 2, 0, 1, 5 }, new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 } };
		NumMatrix nm = new NumMatrix(matrix);

		System.out.println(nm.sumRegion(2, 1, 4, 3));
		System.out.println(nm.sumRegion(1, 1, 2, 2));
		System.out.println(nm.sumRegion(1, 2, 2, 4));
	}

	static class NumMatrix {
		int[][] sumMatrix;
		int[][] matrix;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0) {
				return;
			}
			this.sumMatrix = matrix;
			sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
			Arrays.fill(sumMatrix[0], 0);
			for (int i = 0; i < sumMatrix.length; i++) {
				sumMatrix[i][0] = 0;
			}
			for (int i = 1; i < sumMatrix[0].length; i++) {
				sumMatrix[1][i] = sumMatrix[1][i - 1] + matrix[0][i - 1];
			}
			for (int i = 1; i < sumMatrix.length; i++) {
				sumMatrix[i][1] = sumMatrix[i - 1][1] + matrix[i - 1][0];
			}

			for (int i = 2; i < sumMatrix.length; i++) {
				for (int j = 2; j < sumMatrix[0].length; j++) {
					sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i - 1][j - 1] + sumMatrix[i][j - 1]
							- sumMatrix[i - 1][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int rowMax = Math.max(row1, row2);
			int rowMin = Math.min(row1, row2);
			int colMax = Math.max(col1, col2);
			int colMin = Math.min(col1, col2);

			return sumMatrix[rowMax + 1][colMax + 1] - sumMatrix[rowMax + 1][colMin] - sumMatrix[rowMin][colMax + 1]
					+ sumMatrix[rowMin][colMin];
		}
	}
}
