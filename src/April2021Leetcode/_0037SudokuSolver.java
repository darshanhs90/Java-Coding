package April2021Leetcode;

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
	static HashSet[] rowArr, colArr, boxArr;

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

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					char c = board[i][j];
					int box = getBox(i, j);
					rowArr[i].add(c);
					colArr[j].add(c);
					boxArr[getBox(i, j)].add(c);
				}
			}
		}
		backtrack(0, 0, board);
	}

	public static boolean canPlace(int i, int j, char c) {
		if (rowArr[i].contains(c))
			return false;
		if (colArr[j].contains(c))
			return false;
		if (boxArr[getBox(i, j)].contains(c))
			return false;
		return true;
	}

	public static void placeVal(int i, int j, char c, char[][] board) {
		rowArr[i].add(c);
		colArr[j].add(c);
		boxArr[getBox(i, j)].add(c);
		board[i][j] = c;
	}

	public static void removeVal(int i, int j, char c, char[][] board) {
		rowArr[i].remove(c);
		colArr[j].remove(c);
		boxArr[getBox(i, j)].remove(c);
		board[i][j] = '.';
	}

	public static void placeNextVal(int i, int j, char[][] board) {
		if (i == 8 && j == 8) {
			solved = true;
			return;
		} else {
			if (j == 8) {
				i += 1;
				j = 0;
			} else {
				j += 1;
			}
			backtrack(i, j, board);
		}
	}

	public static void backtrack(int i, int j, char[][] board) {
		if (board[i][j] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(i, j, c)) {
					placeVal(i, j, c, board);
					placeNextVal(i, j, board);

					if (!solved) {
						removeVal(i, j, c, board);
					}
				}
			}
		} else {
			placeNextVal(i, j, board);
		}
	}

	public static int getBox(int row, int col) {
		return (row / 3) * 3 + (col / 3);
	}

}
