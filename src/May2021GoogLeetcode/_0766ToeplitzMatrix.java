package May2021GoogLeetcode;

public class _0766ToeplitzMatrix {
	public static void main(String[] args) {
		System.out.println(isToeplitzMatrix(
				new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 1, 2, 3 }, new int[] { 9, 5, 1, 2 }, }));
		System.out.println(isToeplitzMatrix(new int[][] { new int[] { 1, 2 }, new int[] { 2, 2 }, }));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return true;
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = rows - 1; i >= 0; i--) {
			if (!equal(i, 0, matrix))
				return false;
		}

		for (int i = 1; i < cols; i++) {
			if (!equal(0, i, matrix))
				return false;
		}
		return true;
	}

	public static boolean equal(int currRow, int currCol, int[][] matrix) {
		int baseVal = matrix[currRow][currCol];
		while (currRow < matrix.length && currCol < matrix[0].length) {
			if (matrix[currRow][currCol] != baseVal)
				return false;
			currRow++;
			currCol++;
		}
		return true;
	}
}
