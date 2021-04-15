package April2021Leetcode;

public class _0419BattleshipsInABoard {

	public static void main(String[] args) {
		System.out.println(countBattleships(new char[][] { new char[] { 'X', '.', '.', 'X' },
				new char[] { '.', '.', '.', 'X' }, new char[] { '.', '.', '.', 'X' } }));
	}

	public static int countBattleships1(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				if (i > 0 && board[i - 1][j] == 'X')
					continue;
				if (j > 0 && board[i][j - 1] == 'X')
					continue;
				count++;
			}
		}
		return count;
	}

	public static int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					dfs(i, j, board);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int x, int y, char[][] board) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '.')
			return;
		board[x][y] = '.';
		dfs(x - 1, y, board);
		dfs(x + 1, y, board);
		dfs(x, y - 1, board);
		dfs(x, y + 1, board);
	}

}
