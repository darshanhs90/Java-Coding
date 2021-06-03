package May2021GoogLeetcode;

import java.util.HashSet;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(0, i, j, board, word, new HashSet<String>()))
						return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(int index, int row, int col, char[][] board, String word, HashSet<String> visited) {
		if (index == word.length())
			return true;
		if (word.charAt(index) != board[row][col])
			return false;
		if (index == word.length() - 1)
			return true;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		visited.add(row + "/" + col);
		for (int i = 0; i < dirs.length; i++) {
			int newRow = row + dirs[i][0];
			int newCol = col + dirs[i][1];

			if (newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length
					|| visited.contains(newRow + "/" + newCol)) {
				continue;
			}

			if (dfs(index + 1, newRow, newCol, board, word, visited))
				return true;
		}
		visited.remove(row + "/" + col);
		return false;
	}
}
