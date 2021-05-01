package May2021PrepLeetcode;

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

	static HashSet[] rowArr, colArr, boxArr;
	static boolean isSolved;

	public static void solveSudoku(char[][] board) {
		isSolved = false;
		rowArr = new HashSet[9];
		colArr = new HashSet[9];
		boxArr = new HashSet[9];

		for (int i = 0; i < 9; i++) {
			rowArr[i] = new HashSet<Character>();
			colArr[i] = new HashSet<Character>();
			boxArr[i] = new HashSet<Character>();
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (c != '.') {
					rowArr[i].add(c);
					colArr[j].add(c);
					boxArr[getBox(i, j)].add(c);
				}
			}
		}
		backtrack(0, 0, board);
	}

	public static void backtrack(int row, int col, char[][] board) {
		if (board[row][col] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(row, col, c)) {
					placeVal(row, col, c, board);
					placeNextVal(row, col, board);

					if (!isSolved) {
						removeVal(row, col, c, board);
					}
				}
			}
		} else {
			placeNextVal(row, col, board);
		}
	}

	public static void placeNextVal(int row, int col, char[][] board) {
		if (row == 8 && col == 8) {
			isSolved = true;
		} else {
			if (col == 8) {
				col = 0;
				row += 1;
			} else {
				col += 1;
			}
			backtrack(row, col, board);
		}
	}

	public static void removeVal(int row, int col, char c, char[][] board) {
		rowArr[row].remove(c);
		colArr[col].remove(c);
		boxArr[getBox(row, col)].remove(c);
		board[row][col] = '.';
	}

	public static void placeVal(int row, int col, char c, char[][] board) {
		rowArr[row].add(c);
		colArr[col].add(c);
		boxArr[getBox(row, col)].add(c);
		board[row][col] = c;
	}

	public static boolean canPlace(int row, int col, char c) {
		if (rowArr[row].contains(c) || colArr[col].contains(c) || boxArr[getBox(row, col)].contains(c))
			return false;
		return true;
	}

	public static int getBox(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}

}
