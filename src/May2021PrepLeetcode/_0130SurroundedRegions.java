package May2021PrepLeetcode;

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
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				dfs(i, 0, board);
			}
			if (board[i][cols - 1] == 'O') {
				dfs(i, cols - 1, board);
			}
		}

		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				dfs(0, i, board);
			}
			if (board[rows - 1][i] == 'O') {
				dfs(rows - 1, i, board);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '1') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public static void dfs(int x, int y, char[][] board) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O')
			return;
		board[x][y] = '1';
		dfs(x - 1, y, board);
		dfs(x + 1, y, board);
		dfs(x, y - 1, board);
		dfs(x, y + 1, board);
	}
}
