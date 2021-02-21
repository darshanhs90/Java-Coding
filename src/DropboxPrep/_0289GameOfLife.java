package DropboxPrep;

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

	// Live - 1
	// Dead - 0

	// L D
	// L 1 2
	// D 3 0

	public static void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				populateArr(i, j, board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2)
					board[i][j] = 0;
				else if (board[i][j] == 3)
					board[i][j] = 1;
			}
		}
	}

	public static void populateArr(int x, int y, int[][] board) {
		int count = 0;
		count += getValue(x - 1, y - 1, board);
		count += getValue(x - 1, y, board);
		count += getValue(x - 1, y + 1, board);
		count += getValue(x, y - 1, board);
		count += getValue(x, y + 1, board);
		count += getValue(x + 1, y - 1, board);
		count += getValue(x + 1, y, board);
		count += getValue(x + 1, y + 1, board);

		if (board[x][y] == 1) {
			if (count < 2 || count > 3)
				board[x][y] = 2;
		} else {
			if (count == 3)
				board[x][y] = 3;
		}
	}

	public static int getValue(int x, int y, int[][] board) {
		if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || board[x][y] == 3 || board[x][y] == 0)
			return 0;
		return 1;
	}

}
