package April2021PrepLeetcode;

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

		public NumMatrix(int[][] matrix) {
		}

		public void update(int row, int col, int val) {
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {

		}
	}
}
