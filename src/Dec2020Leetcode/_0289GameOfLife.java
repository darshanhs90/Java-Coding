package Dec2020Leetcode;

import java.util.Arrays;

public class _0289GameOfLife {

	public static void main(String[] args) {
		gameOfLife(new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
				new int[] { 0, 0, 0 } });

		gameOfLife(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } });
	}

	// Any live cell with fewer than two live neighbors dies as if caused by
	// under-population.
	// Any live cell with two or three live neighbors lives on to the next
	// generation.
	// Any live cell with more than three live neighbors dies, as if by
	// over-population.
	// Any dead cell with exactly three live neighbors becomes a live cell, as if by
	// reproduction.

	public static void gameOfLife(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = getNeighborsCount(i, j, board);
				if (board[i][j] == 1) {
					if (count < 2)
						board[i][j] = -1;
					else if (count >= 2 && count <= 3)
						board[i][j] = 1;
					else if (count > 3)
						board[i][j] = -1;
				} else {
					if (count == 3)
						board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == -1) {
					board[i][j] = 0;
				} else if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
			System.out.println(Arrays.toString(board[i]));
		}

	}

	public static int getNeighborsCount(int x, int y, int[][] board) {
		int count = 0;

		if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == -1)) {
			count++;
		}

		if (x - 1 >= 0 && (board[x - 1][y] == 1 || board[x - 1][y] == -1)) {
			count++;
		}

		if (x - 1 >= 0 && y + 1 < board[0].length && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == -1)) {
			count++;
		}

		if (y - 1 >= 0 && (board[x][y - 1] == 1 || board[x][y - 1] == -1)) {
			count++;
		}
		if (y + 1 < board[0].length && (board[x][y + 1] == 1 || board[x][y + 1] == -1)) {
			count++;
		}
		if (x + 1 < board.length && y - 1 >= 0 && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == -1)) {
			count++;
		}
		if (x + 1 < board.length && (board[x + 1][y] == 1 || board[x + 1][y] == -1)) {
			count++;
		}
		if (x + 1 < board.length && y + 1 < board[0].length
				&& (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == -1)) {
			count++;
		}
		return count;

	}

}
