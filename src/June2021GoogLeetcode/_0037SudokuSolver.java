package June2021GoogLeetcode;

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

	static HashSet[] rowSet, colSet, boxSet;
	static boolean isSolved;

	public static void solveSudoku(char[][] board) {
		rowSet = new HashSet[9];
		colSet = new HashSet[9];
		boxSet = new HashSet[9];
		for (int i = 0; i < board.length; i++) {
			rowSet[i] = new HashSet<Character>();
			colSet[i] = new HashSet<Character>();
			boxSet[i] = new HashSet<Character>();
		}
		isSolved = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (c != '.') {
					int box = getBox(i, j);
					rowSet[i].add(c);
					colSet[j].add(c);
					boxSet[box].add(c);
				}
			}
		}

		backtrack(0, 0, board);
	}

	public static void backtrack(int row, int col, char[][] board) {
		if (board[row][col] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(row, col, c)) {
					placeVal(row, col, board, c);
					placeNextVal(row, col, board);

					if (!isSolved) {
						removeVal(row, col, board, c);
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

	public static int getBox(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}

	public static boolean canPlace(int row, int col, char c) {
		if (rowSet[row].contains(c) || colSet[col].contains(c) || boxSet[getBox(row, col)].contains(c))
			return false;
		return true;
	}

	public static void placeVal(int row, int col, char[][] board, char c) {
		rowSet[row].add(c);
		colSet[col].add(c);
		boxSet[getBox(row, col)].add(c);
		board[row][col] = c;
	}

	public static void removeVal(int row, int col, char[][] board, char c) {
		rowSet[row].remove(c);
		colSet[col].remove(c);
		boxSet[getBox(row, col)].remove(c);
		board[row][col] = '.';
	}

}
