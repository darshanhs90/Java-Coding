package Nov2020Leetcode;

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
		int rows = matrix.length;
		int cols = matrix[0].length;
		int startIndex = 0;
		int endIndex = rows * cols - 1;

		while (startIndex <= endIndex) {
			int mid = (startIndex + endIndex) / 2;
			int midVal = matrix[mid / cols][mid % cols];
			if (midVal == target) {
				return true;
			} else if (midVal < target) {
				startIndex = mid + 1;
			} else {
				endIndex = mid - 1;
			}
		}
		return false;
	}

}
