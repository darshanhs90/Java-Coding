package April2021PrepLeetcode;

import java.util.Arrays;

public class _0130SurroundedRegions {

	public static void main(String[] args) {
		solve(new char[][] { new char[] { 'X', 'X', 'X', 'X' }, new char[] { 'X', 'O', 'O', 'X' },
				new char[] { 'X', 'X', 'O', 'X' }, new char[] { 'X', 'O', 'X', 'X' } });

		solve(new char[][] { new char[] { 'O', 'O', 'O' }, new char[] { 'O', 'O', 'O' },
				new char[] { 'O', 'O', 'O' } });
	}

	public static void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int rows = board.length - 1;
		int cols = board[0].length - 1;

		for (int i = 0; i <= cols; i++) {
			if (board[0][i] == 'O')
				captureAllZeros(0, i, board);

			if (board[rows][i] == 'O')
				captureAllZeros(rows, i, board);
		}

		for (int i = 0; i <= rows; i++) {
			if (board[i][0] == 'O')
				captureAllZeros(i, 0, board);

			if (board[i][cols] == 'O')
				captureAllZeros(i, cols, board);
		}

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '1')
					board[i][j] = 'O';
			}
		}
	}

	public static void captureAllZeros(int i, int j, char[][] board) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O')
			return;
		board[i][j] = '1';

		captureAllZeros(i - 1, j, board);
		captureAllZeros(i + 1, j, board);
		captureAllZeros(i, j - 1, board);
		captureAllZeros(i, j + 1, board);
	}
}
