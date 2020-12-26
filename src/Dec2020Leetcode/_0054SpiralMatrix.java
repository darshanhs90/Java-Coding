package Dec2020Leetcode;

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
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return list;
		int topRow = 0, leftCol = 0, bottomRow = matrix.length - 1, rightCol = matrix[0].length - 1;
		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int i = leftCol; i <= rightCol; i++) {
				list.add(matrix[topRow][i]);
			}
			topRow++;

			for (int i = topRow; i <= bottomRow; i++) {
				list.add(matrix[i][rightCol]);
			}
			rightCol--;

			if (topRow <= bottomRow) {
				for (int i = rightCol; i >= leftCol; i--) {
					list.add(matrix[bottomRow][i]);
				}
				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--) {
					list.add(matrix[i][leftCol]);
				}
				leftCol++;
			}
		}
		return list;
	}

}
