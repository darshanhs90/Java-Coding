package Leetcode2020Nov;

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
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!isValid(board, i, j))
					return false;
			}
		}
		return true;
	}

	public static boolean isValid(char[][] board, int x, int y) {
		boolean isValidBox = x % 3 == 0 && y % 3 == 0 ? isValidBox(board, x, y) : true;
		return isValidRow(board, x) && isValidCol(board, y) && isValidBox;
	}

	public static boolean isValidRow(char[][] board, int x) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < board[0].length; i++) {
			char c = board[x][i];
			if (c != '.') {
				if (set.contains(c))
					return false;
				set.add(c);
			}
		}
		return true;
	}

	public static boolean isValidCol(char[][] board, int x) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < board.length; i++) {
			char c = board[i][x];
			if (c != '.') {
				if (set.contains(c))
					return false;
				set.add(c);
			}
		}
		return true;
	}

	public static boolean isValidBox(char[][] board, int x, int y) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
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

}
