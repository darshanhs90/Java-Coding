package Jan2021Leetcode;

public class _0073SetMatrixZeroes {

	public static void main(String[] args) {
		setZeroes(new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 1, 1, 1 }, });
		setZeroes(new int[][] { new int[] { 0, 1, 2, 0 }, new int[] { 3, 4, 5, 2 }, new int[] { 1, 3, 1, 5 }, });
	}

	public static void setZeroes(int[][] matrix) {
		int noOfRows = matrix.length;
		int noOfCols = matrix[0].length;

		boolean[] rowArr = new boolean[noOfRows];
		boolean[] colArr = new boolean[noOfCols];

		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if (matrix[i][j] == 0) {
					rowArr[i] = true;
					colArr[j] = true;
				}
			}
		}

		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if (rowArr[i] || colArr[j])
					matrix[i][j] = 0;
			}
		}
	}

	public static void setZeroes1(int[][] matrix) {
		int noOfRows = matrix.length;
		int noOfCols = matrix[0].length;

		boolean firstRowHasZero = false, firstColHasZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowHasZero = true;
				break;
			}
		}

		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfCols; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfCols; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}

		if (firstRowHasZero) {
			for (int i = 0; i < noOfCols; i++) {
				matrix[0][i] = 0;
			}
		}

		if (firstColHasZero) {
			for (int i = 0; i < noOfRows; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
