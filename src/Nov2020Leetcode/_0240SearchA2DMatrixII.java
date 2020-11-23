package Nov2020Leetcode;

public class _0240SearchA2DMatrixII {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { new int[] { 1, 4, 7, 11, 15 }, new int[] { 2, 5, 8, 12, 19 },
				new int[] { 3, 6, 9, 16, 22 }, new int[] { 10, 13, 14, 17, 24 }, new int[] { 18, 21, 23, 26, 30 } },
				5));

		System.out.println(searchMatrix(new int[][] { new int[] { 1, 4, 7, 11, 15 }, new int[] { 2, 5, 8, 12, 19 },
				new int[] { 3, 6, 9, 16, 22 }, new int[] { 10, 13, 14, 17, 24 }, new int[] { 18, 21, 23, 26, 30 } },
				20));

		System.out.println(searchMatrix(new int[][] { new int[] { 1, 4, 7, 11, 15 }, new int[] { 2, 5, 8, 12, 19 },
				new int[] { 3, 6, 9, 16, 22 }, new int[] { 10, 13, 14, 17, 24 }, new int[] { 18, 21, 23, 26, 30 } },
				30));

		System.out.println(searchMatrix(new int[][] { new int[] { 1, 4, 7, 11, 15 }, new int[] { 2, 5, 8, 12, 19 },
				new int[] { 3, 6, 9, 16, 22 }, new int[] { 10, 13, 14, 17, 24 }, new int[] { 18, 21, 23, 26, 30 } },
				0));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int row = 0, col = matrix[0].length - 1;

		while (row < matrix.length && col > -1 && col < matrix[0].length) {
			int val = matrix[row][col];
			if (val == target)
				return true;
			else if (target > val) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

}
