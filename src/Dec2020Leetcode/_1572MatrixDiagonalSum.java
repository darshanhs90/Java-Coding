package Dec2020Leetcode;

public class _1572MatrixDiagonalSum {
	public static void main(String[] args) {
		System.out.println(
				diagonalSum(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }));
		System.out.println(diagonalSum(new int[][] { new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 },
				new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 } }));
	}

	public static int diagonalSum(int[][] mat) {
		int sum = findForwardSum(mat) + findBackwardSum(mat);
		int rows = mat.length - 1;
		int cols = rows;
		if (mat.length % 2 != 0) {
			sum -= mat[rows / 2][cols / 2];
		}
		return sum;
	}

	public static int findForwardSum(int[][] mat) {
		int rows = mat.length - 1;
		int cols = rows;
		int currRow = 0, currCol = 0;
		int sum = 0;
		while (currRow <= rows && currCol <= cols) {
			sum += mat[currRow][currCol];
			currRow++;
			currCol++;
		}
		return sum;
	}

	public static int findBackwardSum(int[][] mat) {
		int rows = mat.length - 1;
		int cols = rows;
		int currRow = 0, currCol = cols;
		int sum = 0;
		while (currRow <= rows && currCol >= 0) {
			sum += mat[currRow][currCol];
			currCol--;
			currRow++;
		}
		return sum;
	}
}
