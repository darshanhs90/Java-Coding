package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0054SpiralMatrix {
	public static void main(String[] args) {

		System.out.println(
				spiralOrder(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }));

		System.out.println(spiralOrder(
				new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8 }, new int[] { 9, 10, 11, 12 } }));

		System.out.println(spiralOrder(new int[][] { new int[] { 2, 5, 8 }, new int[] { 4, 0, -1 } }));

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> output = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return output;
		int topRow = 0, bottomRow = matrix.length - 1, leftCol = 0, rightCol = matrix[0].length - 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				output.add(matrix[topRow][i]);
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				output.add(matrix[i][rightCol]);
			}

			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					output.add(matrix[bottomRow][i]);
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					output.add(matrix[i][leftCol]);
				}

				leftCol++;
			}
		}

		return output;
	}

}
