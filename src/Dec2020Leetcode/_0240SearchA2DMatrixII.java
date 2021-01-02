package Dec2020Leetcode;

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
		int row = 0, col = matrix[0].length - 1;
		while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {

			int val = matrix[row][col];
			if (val == target)
				return true;
			if (val > target)
				col--;
			else
				row++;
		}
		return false;
	}

}
