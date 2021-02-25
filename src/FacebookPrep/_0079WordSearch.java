package FacebookPrep;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && dfs(i, j, 0, word, board, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(int x, int y, int index, String word, char[][] board, boolean[][] visited) {
		if (index == word.length())
			return true;
		if (index > word.length() || x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || visited[x][y]
				|| board[x][y] != word.charAt(index))
			return false;

		visited[x][y] = true;
		boolean out = false;
		out = out || dfs(x - 1, y, index + 1, word, board, visited);
		out = out || dfs(x + 1, y, index + 1, word, board, visited);
		out = out || dfs(x, y - 1, index + 1, word, board, visited);
		out = out || dfs(x, y + 1, index + 1, word, board, visited);
		visited[x][y] = false;
		return out;
	}
}
