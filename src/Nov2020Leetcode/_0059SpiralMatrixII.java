package Nov2020Leetcode;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
	}

	public static int[][] generateMatrix(int n) {
		int[][] out = new int[n][n];
		int topRow = 0;
		int bottomRow = n - 1;
		int leftCol = 0;
		int rightCol = n - 1;
		int val = 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				out[topRow][i] = val;
				val++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				out[i][rightCol] = val;
				val++;
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					out[bottomRow][i] = val;
					val++;
				}
			}
			bottomRow--;

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					out[i][leftCol] = val;
					val++;
				}
			}
			leftCol++;
		}

		return out;
	}
}
