package Mar2021Leetcode;

import java.util.HashSet;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	static boolean solved;

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		solved = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					dfs(i, j, 0, board, word, new HashSet<String>());
					if (solved)
						return true;

				}
			}
		}
		return false;
	}

	public static void dfs(int row, int col, int index, char[][] board, String word, HashSet<String> visited) {
		if (index == word.length()) {
			solved = true;
			return;
		}

		if (solved || row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| visited.contains(row + "/" + col) || board[row][col] != word.charAt(index))
			return;

		visited.add(row + "/" + col);
		dfs(row - 1, col, index + 1, board, word, visited);
		dfs(row + 1, col, index + 1, board, word, visited);
		dfs(row, col + 1, index + 1, board, word, visited);
		dfs(row, col - 1, index + 1, board, word, visited);
		visited.remove(row + "/" + col);
	}

}
