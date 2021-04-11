package April2021Leetcode;

import java.util.HashSet;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	static boolean exists;

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					exists = false;
					dfs(0, i, j, board, word, new HashSet<String>());
					if (exists)
						return true;
				}
			}
		}
		return false;
	}

	public static void dfs(int index, int x, int y, char[][] board, String word, HashSet<String> visited) {
		if (index == word.length()) {
			exists = true;
			return;
		}

		if (index >= word.length() || x < 0 || y < 0 || x >= board.length || y >= board[0].length
				|| visited.contains(x + "/" + y) || exists || word.charAt(index) != board[x][y])
			return;

		visited.add(x + "/" + y);
		dfs(index + 1, x - 1, y, board, word, visited);
		dfs(index + 1, x + 1, y, board, word, visited);
		dfs(index + 1, x, y - 1, board, word, visited);
		dfs(index + 1, x, y + 1, board, word, visited);
		visited.remove(x + "/" + y);
	}
}
