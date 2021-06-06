package June2021GoogLeetcode;

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
		int cols = board[0].length;
		int rows = board.length;
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				capture(i, 0, board);
			}

			if (board[i][cols - 1] == 'O') {
				capture(i, cols - 1, board);
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				capture(0, i, board);
			}

			if (board[rows - 1][i] == 'O') {
				capture(rows - 1, i, board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}

	public static void capture(int x, int y, char[][] board) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O')
			return;
		board[x][y] = 'Y';
		capture(x - 1, y, board);
		capture(x + 1, y, board);
		capture(x, y - 1, board);
		capture(x, y + 1, board);
	}
}
