package May2021PrepLeetcode;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {
		int val = 1;
		int[][] matrix = new int[n][n];
		int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				matrix[topRow][i] = val++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				matrix[i][rightCol] = val++;
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					matrix[bottomRow][i] = val++;
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					matrix[i][leftCol] = val++;
				}
				leftCol++;
			}
		}
		return matrix;
	}

}
