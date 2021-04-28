package May2021PrepLeetcode;

public class _0999AvailableCapturesForRook {

	public static void main(String[] args) {
		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'R', '.', '.', '.', 'p' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'B', 'R', 'B', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'B', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

	}

	public static int numRookCaptures(char[][] board) {
		if (board == null || board.length == 0)
			return 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'R')
					return capture(i, j, board, -1, 0) + capture(i, j, board, 1, 0) + capture(i, j, board, 0, -1)
							+ capture(i, j, board, 0, 1);
			}
		}
		return 0;
	}

	public static int capture(int x, int y, char[][] board, int dx, int dy) {
		while (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
			if (board[x][y] == 'B')
				return 0;
			if (board[x][y] == 'p')
				return 1;
			x += dx;
			y += dy;
		}
		return 0;
	}
}
