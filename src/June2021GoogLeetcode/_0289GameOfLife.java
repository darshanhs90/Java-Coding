package June2021GoogLeetcode;

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

	// - 0 1
	// 0 0 2
	// 1 3 1
	public static void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = getCount(i, j, board);
				if (board[i][j] == 1) {
					if (count < 2 || count > 3) {
						board[i][j] = 3;
					}
				} else {
					if (count == 3) {
						board[i][j] = 2;
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2) {

					board[i][j] = 1;
				} else if (board[i][j] == 3) {
					board[i][j] = 0;
				}
			}
		}
	}

	public static int getCount(int x, int y, int[][] board) {
		int[][] dirs = new int[][] { new int[] { -1, -1 }, new int[] { -1, 0 }, new int[] { -1, 1 },
				new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { 1, -1 }, new int[] { 1, 0 }, new int[] { 1, 1 } };
		int count = 0;
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length)
				continue;
			if (board[newX][newY] == 1 || board[newX][newY] == 3)
				count++;
		}

		return count;
	}

}
