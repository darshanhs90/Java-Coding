package Feb2021Leetcode;

import java.util.Arrays;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {

		int[][] out = new int[n][n];
		int topRow = 0, leftCol = 0, bottomRow = n - 1, rightCol = n - 1;
		int count = 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				out[topRow][i] = count;
				count++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				out[i][rightCol] = count;
				count++;
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					out[bottomRow][i] = count;
					count++;
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					out[i][leftCol] = count;
					count++;
				}
				leftCol++;
			}
		}

		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}
		return out;
	}

}
