package April2021PrepLeetcode;

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
		int currRow = 0, currCol = matrix[0].length - 1;
		while (currRow < matrix.length && currCol >= 0) {
			if (matrix[currRow][currCol] == target)
				return true;
			if (matrix[currRow][currCol] > target) {
				currCol--;
			} else {
				currRow++;
			}
		}
		return false;
	}

}
