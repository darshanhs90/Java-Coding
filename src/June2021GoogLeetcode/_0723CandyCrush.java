package June2021GoogLeetcode;

import java.util.Arrays;

public class _0723CandyCrush {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(candyCrush(new int[][] { new int[] { 110, 5, 112, 113, 114 },
				new int[] { 210, 211, 5, 213, 214 }, new int[] { 310, 311, 3, 313, 314 },
				new int[] { 410, 411, 412, 5, 414 }, new int[] { 5, 1, 512, 3, 3 }, new int[] { 610, 4, 1, 613, 614 },
				new int[] { 710, 1, 2, 713, 714 }, new int[] { 810, 1, 2, 1, 1 }, new int[] { 1, 1, 2, 2, 2 },
				new int[] { 4, 1, 4, 4, 1014 } })));
	}

	public static int[][] candyCrush(int[][] board) {
		boolean found = false;

		int rows = board.length;
		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int baseVal = Math.abs(board[i][j]);
				if (baseVal == 0)
					continue;
				if (i + 2 < rows && Math.abs(board[i + 1][j]) == baseVal && Math.abs(board[i + 2][j]) == baseVal) {
					found = true;
					board[i][j] = -1 * baseVal;
					board[i + 1][j] = -1 * baseVal;
					board[i + 2][j] = -1 * baseVal;
				}

				if (j + 2 < cols && Math.abs(board[i][j + 1]) == baseVal && Math.abs(board[i][j + 2]) == baseVal) {
					found = true;
					board[i][j] = -1 * baseVal;
					board[i][j + 1] = -1 * baseVal;
					board[i][j + 2] = -1 * baseVal;
				}
			}
		}

		if (found) {
			for (int col = 0; col < cols; col++) {
				int index = board.length - 1;
				for (int row = board.length - 1; row >= 0; row--) {
					if (board[row][col] > 0) {
						board[index--][col] = board[row][col];
					}
				}

				for (int j = 0; j <= index; j++) {
					board[j][col] = 0;
				}
			}

			return candyCrush(board);
		}
		return board;
	}
}
