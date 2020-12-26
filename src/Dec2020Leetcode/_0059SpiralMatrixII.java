package Dec2020Leetcode;

public class _0059SpiralMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(3));
		System.out.println(generateMatrix(1));
		System.out.println(generateMatrix(4));
	}

	public static int[][] generateMatrix(int n) {
		int[][] output = new int[n][n];
		int count = 1;
		int topRow = 0, bottomRow = output.length - 1;
		int leftCol = 0, rightCol = output[0].length - 1;

		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				output[topRow][i] = count;
				count++;
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				output[i][rightCol] = count;
				count++;
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					output[bottomRow][i] = count;
					count++;
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					output[i][leftCol] = count;
					count++;
				}
				leftCol++;
			}
		}

		return output;
	}

}
