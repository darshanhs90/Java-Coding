package Leetcode2020Nov;

public class _0766ToeplitzMatrix {
	public static void main(String[] args) {
		System.out.println(isToeplitzMatrix(
				new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 1, 2, 3 }, new int[] { 9, 5, 1, 2 }, }));
		System.out.println(isToeplitzMatrix(new int[][] { new int[] { 1, 2 }, new int[] { 2, 2 }, }));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length < 1)
			return true;

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != matrix[i - 1][j - 1])
					return false;
			}
		}

		return true;
	}
}
