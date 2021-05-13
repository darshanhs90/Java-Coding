package May2021Leetcode;

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
		if (board == null || board.length == 0)
			return false;
		found = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					dfs(0, i, j, board, word, new HashSet<String>());
					if (found)
						return true;
				}
			}
		}
		return false;
	}

	public static void dfs(int index, int x, int y, char[][] board, String word, HashSet<String> visited) {
		if (index == word.length()) {
			found = true;
			return;
		}

		if (found || x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(index) != board[x][y]
				|| visited.contains(x + "/" + y))
			return;

		visited.add(x + "/" + y);
		dfs(index + 1, x - 1, y, board, word, visited);
		dfs(index + 1, x + 1, y, board, word, visited);
		dfs(index + 1, x, y - 1, board, word, visited);
		dfs(index + 1, x, y + 1, board, word, visited);
		visited.remove(x + "/" + y);
	}
}
