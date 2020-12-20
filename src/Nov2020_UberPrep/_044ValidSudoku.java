package Nov2020_UberPrep;

import java.util.HashSet;

public class _044ValidSudoku {

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
			if (!validateRow(i, board))
				return false;
			if (!validateCol(i, board))
				return false;
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!validateBox(i, j, i + 3, j + 3, board))
					return false;
			}
		}

		return true;

	}

	public static boolean validateBox(int rowStart, int colStart, int rowEnd, int colEnd, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				char c = board[i][j];
				if (c >= '1' && c <= '9') {
					if (set.contains(c))
						return false;
					set.add(c);
				} else if (c != '.') {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean validateRow(int row, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[row][i];
			if (c >= '1' && c <= '9') {
				if (set.contains(c))
					return false;
				set.add(c);
			} else if (c != '.') {
				return false;
			}
		}
		return true;
	}

	public static boolean validateCol(int col, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[i][col];
			if (c >= '1' && c <= '9') {
				if (set.contains(c))
					return false;
				set.add(c);
			} else if (c != '.') {
				return false;
			}
		}
		return true;
	}

}
