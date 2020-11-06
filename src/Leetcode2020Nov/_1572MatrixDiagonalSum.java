package Leetcode2020Nov;

public class _1572MatrixDiagonalSum {
	public static void main(String[] args) {
		System.out.println(
				diagonalSum(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }));
		System.out.println(diagonalSum(new int[][] { new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 },
				new int[] { 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1 } }));
	}

	public static int diagonalSum(int[][] mat) {
		int sum = 0;
		int leftCol = 0;
		int rightCol = mat[0].length - 1;
		for (int i = 0; i < mat.length; i++) {
			if (leftCol == rightCol) {
				sum += mat[i][leftCol];
			} else {
				sum += mat[i][leftCol];
				sum += mat[i][rightCol];
			}
			leftCol++;
			rightCol--;
		}
		return sum;
	}
}
