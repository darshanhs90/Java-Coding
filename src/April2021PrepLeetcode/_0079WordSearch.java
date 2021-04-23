package April2021PrepLeetcode;

import java.util.HashSet;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	static boolean found;

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		found = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					dfs(i, j, 0, board, word, new HashSet<String>());
					if (found)
						return true;
				}
			}
		}
		return false;
	}

	public static void dfs(int x, int y, int index, char[][] board, String word, HashSet<String> visited) {
		if (index == word.length()) {
			found = true;
			return;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || found || index >= word.length()
				|| visited.contains(x + "/" + y) || board[x][y] != word.charAt(index))
			return;
		visited.add(x + "/" + y);
		dfs(x - 1, y, index + 1, board, word, visited);
		dfs(x + 1, y, index + 1, board, word, visited);
		dfs(x, y - 1, index + 1, board, word, visited);
		dfs(x, y + 1, index + 1, board, word, visited);
		visited.remove(x + "/" + y);
	}
}
