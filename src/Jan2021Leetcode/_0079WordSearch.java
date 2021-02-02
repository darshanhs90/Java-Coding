package Jan2021Leetcode;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	static boolean exists = false;

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		exists = false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					dfs(i, j, 0, board, word, visited);
					if (exists)
						return true;
				}
			}
		}
		return false;
	}

	public static void dfs(int x, int y, int index, char[][] board, String word, boolean[][] visited) {
		if (index == word.length()) {
			exists = true;
			return;
		}
		if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || visited[x][y] || exists
				|| board[x][y] != word.charAt(index))
			return;

		visited[x][y] = true;
		dfs(x - 1, y, index + 1, board, word, visited);
		dfs(x + 1, y, index + 1, board, word, visited);
		dfs(x, y - 1, index + 1, board, word, visited);
		dfs(x, y + 1, index + 1, board, word, visited);
		visited[x][y] = false;
	}
}
