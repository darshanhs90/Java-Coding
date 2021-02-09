package Jan2021Leetcode;

import java.util.Arrays;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int count = 1;
		int topRow = 0, bottomRow = n - 1;
		int leftCol = 0, rightCol = n - 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				matrix[topRow][i] = count;
				count++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				matrix[i][rightCol] = count;
				count++;
			}
			rightCol--;

			if (topRow < bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					matrix[bottomRow][i] = count;
					count++;
				}
				bottomRow--;
			}

			if (leftCol < rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					matrix[i][leftCol] = count;
					count++;
				}
				leftCol++;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		return matrix;
	}

}
