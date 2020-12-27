package Dec2020Leetcode;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word.length() == 0)
			return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(i, j, 0, word, board, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean dfs(int x, int y, int index, String word, char[][] board, boolean[][] visited) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || index >= word.length()
				|| word.charAt(index) != board[x][y])
			return false;

		if (index == word.length() - 1)
			return true;
		visited[x][y] = true;
		boolean outValue = dfs(x - 1, y, index + 1, word, board, visited)
				|| dfs(x + 1, y, index + 1, word, board, visited) || dfs(x, y - 1, index + 1, word, board, visited)
				|| dfs(x, y + 1, index + 1, word, board, visited);
		visited[x][y] = false;
		return outValue;
	}
}
