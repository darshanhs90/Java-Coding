package Jan2021Leetcode;

import java.util.HashSet;

public class _0036ValidSudoku {

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][] { new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

		System.out.println(isValidSudoku(new char[][] { new char[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!checkRow(i, board))
				return false;
			if (!checkCol(i, board))
				return false;
		}

		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board.length; j += 3) {
				if (!checkBox(i, j, i + 3, j + 3, board))
					return false;
			}
		}
		return true;
	}

	public static boolean checkRow(int row, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[row][i];
			if (c != '.') {
				if (c >= '1' && c <= '9' && !set.contains(c)) {
					set.add(c);
				} else
					return false;
			}
		}
		return true;
	}

	public static boolean checkCol(int col, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[i][col];
			if (c != '.') {
				if (c >= '1' && c <= '9' && !set.contains(c)) {
					set.add(c);
				} else
					return false;
			}
		}
		return true;
	}

	public static boolean checkBox(int startRow, int startCol, int endRow, int endCol, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (c >= '1' && c <= '9' && !set.contains(c)) {
						set.add(c);
					} else
						return false;
				}
			}
		}
		return true;
	}

}
