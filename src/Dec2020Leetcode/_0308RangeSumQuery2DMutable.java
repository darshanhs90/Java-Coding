package Dec2020Leetcode;

import java.util.Arrays;

public class _0308RangeSumQuery2DMutable {
	// https://www.youtube.com/watch?v=GURRzAKL1lY
	public static void main(String[] args) {
		NumMatrix nm = new NumMatrix(new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 },
				new int[] { 1, 2, 0, 1, 5 }, new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 } });

		System.out.println(nm.sumRegion(2, 1, 4, 3));// -> 8
		nm.update(3, 2, 2);
		System.out.println(nm.sumRegion(2, 1, 4, 3));// -> 10
	}

	static class NumMatrix {
		int[][] matrix, fw;

		public NumMatrix(int[][] matrix) {
			if (matrix.length == 0)
				return;
			this.fw = new int[matrix.length + 1][matrix[0].length + 1];
			this.matrix = matrix;
			Arrays.fill(fw[0], 0);
			for (int i = 0; i < fw.length; i++) {
				fw[i][0] = 0;
			}

			for (int i = 1; i < fw.length; i++) {
				for (int j = 1; j < fw[0].length; j++) {
					updateBIT(i, j, matrix[i - 1][j - 1]);
				}
			}
		}

		public void updateBIT(int x, int y, int val) {
			for (int i = x; i < fw.length; i = child(i)) {
				for (int j = y; j < fw[0].length; j = child(j)) {
					fw[i][j] += val;
				}
			}
		}

		public int child(int i) {
			return i + (i & -i);
		}

		public int parent(int i) {
			return i - (i & -i);
		}

		public void update(int row, int col, int val) {
			int diff = -matrix[row][col] + val;
			matrix[row][col] = val;
			updateBIT(row + 1, col + 1, diff);
		}

		public int queryBIT(int x, int y) {
			int res = 0;
			for (int i = x; i > 0; i = parent(i)) {
				for (int j = y; j > 0; j = parent(j)) {
					res += fw[i][j];
				}
			}
			return res;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			row1++;
			col1++;
			row2++;
			col2++;
			int a = queryBIT(row2, col2);
			int b = queryBIT(row1 - 1, col1 - 1);
			int c = queryBIT(row2, col1 - 1);
			int d = queryBIT(row1 - 1, col2);
			return (a + b) - (c + d);
		}
	}
}
