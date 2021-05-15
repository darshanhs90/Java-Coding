package May2021Leetcode;

public class _0074SearchA2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(
				new int[][] { new int[] { 1, 3, 5, 7 }, new int[] { 10, 11, 16, 20 }, new int[] { 23, 30, 34, 50 } },
				3));
		System.out.println(searchMatrix(
				new int[][] { new int[] { 1, 3, 5, 7 }, new int[] { 10, 11, 16, 20 }, new int[] { 23, 30, 34, 50 } },
				13));
		System.out.println(searchMatrix(new int[][] {}, 0));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int currRow = 0, currCol = matrix[0].length - 1;
		while (currRow < matrix.length && currCol >= 0) {
			if (matrix[currRow][currCol] == target) {
				return true;
			} else if (matrix[currRow][currCol] > target) {
				currCol--;
			} else {
				currRow++;
			}
		}
		return false;
	}

}
