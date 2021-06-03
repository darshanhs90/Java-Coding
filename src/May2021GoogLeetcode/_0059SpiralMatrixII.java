package May2021GoogLeetcode;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {
		int[][] out = new int[n][n];
		int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
		int count = 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				out[topRow][i] = count++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				out[i][rightCol] = count++;
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					out[bottomRow][i] = count++;
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					out[i][leftCol] = count++;
				}
				leftCol++;
			}
		}
		return out;
	}

}
