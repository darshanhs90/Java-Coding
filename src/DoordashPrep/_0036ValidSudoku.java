package DoordashPrep;

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

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!checkBox(i, j, board))
					return false;
			}
		}
		return true;
	}

	public static boolean checkBox(int row, int col, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (set.contains(c))
						return false;
					set.add(c);
				}
			}
		}
		return true;
	}

	public static boolean checkCol(int col, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[i][col];
			if (c != '.') {
				if (set.contains(c))
					return false;
				set.add(c);
			}
		}
		return true;
	}

	public static boolean checkRow(int row, char[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			char c = board[row][i];
			if (c != '.') {
				if (set.contains(c))
					return false;
				set.add(c);
			}
		}
		return true;
	}

}
