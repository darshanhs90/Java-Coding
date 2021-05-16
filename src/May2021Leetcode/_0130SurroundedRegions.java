package May2021Leetcode;

public class _0130SurroundedRegions {

	public static void main(String[] args) {
		solve(new char[][] { new char[] { 'X', 'X', 'X', 'X' }, new char[] { 'X', 'O', 'O', 'X' },
				new char[] { 'X', 'X', 'O', 'X' }, new char[] { 'X', 'O', 'X', 'X' } });

		solve(new char[][] { new char[] { 'O', 'O', 'O' }, new char[] { 'O', 'O', 'O' },
				new char[] { 'O', 'O', 'O' } });
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				capture(0, i, board);
			}

			if (board[board.length - 1][i] == 'O') {
				capture(board.length - 1, i, board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				capture(i, 0, board);
			}

			if (board[i][board[0].length - 1] == 'O') {
				capture(i, board[0].length - 1, board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void capture(int row, int col, char[][] board) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O')
			return;
		board[row][col] = 'Y';
		capture(row - 1, col, board);
		capture(row + 1, col, board);
		capture(row, col - 1, board);
		capture(row, col + 1, board);
	}
}
