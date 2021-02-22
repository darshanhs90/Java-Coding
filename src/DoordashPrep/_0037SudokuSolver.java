package DoordashPrep;

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

	static boolean solved;
	static HashSet[] rowArr;
	static HashSet[] colArr;
	static HashSet[] boxArr;

	public static void solveSudoku(char[][] board) {
		solved = false;
		rowArr = new HashSet[9];
		colArr = new HashSet[9];
		boxArr = new HashSet[9];

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
					int boxNum = getBox(i, j);
					boxArr[boxNum].add(c);
				}
			}
		}

		backtrack(0, 0, board);
	}

	public static void backtrack(int row, int col, char[][] board) {
		if (board[row][col] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(row, col, c)) {
					placeRow(row, col, c, board);
					placeNextRow(row, col, board);

					if (!solved) {
						removeItem(row, col, c, board);
					}
				}
			}
		} else {
			placeNextRow(row, col, board);
		}
	}

	public static void removeItem(int row, int col, char c, char[][] board) {
		board[row][col] = '.';
		rowArr[row].remove(c);
		colArr[col].remove(c);
		int box = getBox(row, col);
		boxArr[box].remove(c);
	}

	public static void placeNextRow(int row, int col, char[][] board) {
		if (row == 8 && col == 8) {
			solved = true;
			return;
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

	public static void placeRow(int row, int col, char c, char[][] board) {
		board[row][col] = c;
		rowArr[row].add(c);
		colArr[col].add(c);
		int box = getBox(row, col);
		boxArr[box].add(c);
	}

	public static boolean canPlace(int row, int col, char c) {
		if (rowArr[row].contains(c))
			return false;
		if (colArr[col].contains(c))
			return false;

		int box = getBox(row, col);
		if (boxArr[box].contains(c))
			return false;
		return true;
	}

	public static int getBox(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}

}
