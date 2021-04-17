package LeetcodeTemplate;

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

		public NumMatrix(int[][] matrix) {
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
		}
	}
}
