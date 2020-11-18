package Leetcode2020Nov;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	public static boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (wordExists(i, j, visited, board, word))
						return true;
				}
			}
		}

		return false;
	}

	public static boolean wordExists(int x, int y, boolean[][] visited, char[][] board, String word) {
		if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || visited[x][y] == true
				|| (word.length() > 0 && board[x][y] != word.charAt(0)))
			return false;
		word = word.substring(1);
		if (word.length() == 0)
			return true;

		boolean wordExistsFlag = false;
		visited[x][y] = true;
		wordExistsFlag = wordExists(x - 1, y, visited, board, word);
		if (wordExistsFlag)
			return true;
		wordExistsFlag = wordExists(x + 1, y, visited, board, word);
		if (wordExistsFlag)
			return true;
		wordExistsFlag = wordExists(x, y - 1, visited, board, word);
		if (wordExistsFlag)
			return true;
		wordExistsFlag = wordExists(x, y + 1, visited, board, word);
		visited[x][y] = false;
		return wordExistsFlag;
	}
}
