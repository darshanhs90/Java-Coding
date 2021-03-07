package Feb2021Leetcode;

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
		exists = false;
		boolean [][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if(word.charAt(0) == board[i][j])
				{
					dfs(0,i,j,board,word,visited);
					if(exists)
						return true;
				}
			}
		}
		return false;
	}

	public static void dfs(int index, int row, int col, char[][] board, String word, boolean[][] visited) {
		if (index == word.length() || exists) {
			exists = true;
			return;
		}

		if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1
				|| word.charAt(index) != board[row][col] || visited[row][col])
			return;

		visited[row][col] = true;
		dfs(index + 1, row - 1, col, board, word, visited);
		dfs(index + 1, row + 1, col, board, word, visited);
		dfs(index + 1, row, col - 1, board, word, visited);
		dfs(index + 1, row, col + 1, board, word, visited);
		visited[row][col] = false;
	}
}
