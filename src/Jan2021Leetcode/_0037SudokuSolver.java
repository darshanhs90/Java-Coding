package Jan2021Leetcode;

import java.util.HashSet;

public class _0037SudokuSolver {

	public static void main(String[] args) {
		solveSudoku(new char[][] { new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });

		solveSudoku(new char[][] { new char[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });
	}

	static boolean solved = false;
	static HashSet<Character>[] rowArr;
	static HashSet<Character>[] colArr;
	static HashSet<Character>[] boxArr;

	public static void solveSudoku(char[][] board) {
		rowArr = new HashSet[9];
		colArr = new HashSet[9];
		boxArr = new HashSet[9];
		solved = false;

		for (int i = 0; i < 9; i++) {
			rowArr[i] = new HashSet<Character>();
			colArr[i] = new HashSet<Character>();
			boxArr[i] = new HashSet<Character>();
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					rowArr[i].add(c);
					colArr[j].add(c);
					int boxNum = getBoxNum(i, j);
					boxArr[boxNum].add(c);
				}
			}
		}

		backtrack(0, 0, board);
	}

	public static void backtrack(int row, int col, char[][] board) {
		if (board[row][col] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(c, row, col)) {
					placeNum(c, row, col, board);
					placeNextNumber(row, col, board);
					if (!solved) {
						removeNumber(row, col, c, board);
					}
				}
			}
		} else {
			placeNextNumber(row, col, board);
		}
	}

	public static boolean canPlace(char c, int row, int col) {
		if (rowArr[row].contains(c))
			return false;
		if (colArr[col].contains(c))
			return false;
		int boxNum = getBoxNum(row, col);
		if (boxArr[boxNum].contains(c))
			return false;
		return true;
	}

	public static void placeNum(char c, int row, int col, char[][] board) {
		board[row][col] = c;
		rowArr[row].add(c);
		colArr[col].add(c);
		int boxNum = getBoxNum(row, col);
		boxArr[boxNum].add(c);
	}

	public static void placeNextNumber(int row, int col, char[][] board) {
		if (row == 8 && col == 8) {
			solved = true;
		} else {
			if (col == 8) {
				row += 1;
				col = 0;
			} else {
				col += 1;
			}
			backtrack(row, col, board);
		}
	}

	public static void removeNumber(int row, int col, char c, char[][] board) {
		board[row][col] = '.';
		rowArr[row].remove(c);
		colArr[col].remove(c);
		int boxNum = getBoxNum(row, col);
		boxArr[boxNum].remove(c);
	}

	public static int getBoxNum(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}

}
