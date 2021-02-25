package FacebookPrep;

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
		rowArr = new HashSet[9];
		colArr = new HashSet[9];
		boxArr = new HashSet[9];
		isSolved = false;

		for (int i = 0; i < board.length; i++) {
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
					int boxNum = getBox(i, j);
					boxArr[boxNum].add(c);

				}
			}
		}
		backtrack(0, 0, board);
	}

	public static void backtrack(int i, int j, char[][] board) {
		if (board[i][j] == '.') {
			for (char c = '1'; c <= '9'; c++) {
				if (canPlace(i, j, c)) {
					placeChar(i, j, c, board);
					placeNextRow(i, j, board);
					if (!isSolved) {
						removeChar(i, j, c, board);
					}
				}
			}
		} else {
			placeNextRow(i, j, board);
		}
	}

	public static void placeNextRow(int i, int j, char[][] board) {
		if (i == board.length - 1 && j == board.length - 1) {
			isSolved = true;
			return;
		}

		if (j == board.length - 1) {
			i += 1;
			j = 0;
		} else {
			j += 1;
		}
		backtrack(i, j, board);
	}

	public static boolean canPlace(int i, int j, char c) {
		if (rowArr[i].contains(c))
			return false;

		if (colArr[j].contains(c))
			return false;

		int boxNum = getBox(i, j);
		if (boxArr[boxNum].contains(c))
			return false;

		return true;
	}

	public static void removeChar(int i, int j, char c, char[][] board) {
		rowArr[i].remove(c);
		colArr[j].remove(c);
		int boxNum = getBox(i, j);
		boxArr[boxNum].remove(c);
		board[i][j] = '.';
	}

	public static void placeChar(int i, int j, char c, char[][] board) {
		rowArr[i].add(c);
		colArr[j].add(c);
		int boxNum = getBox(i, j);
		boxArr[boxNum].add(c);
		board[i][j] = c;
	}

	public static int getBox(int x, int y) {
		return (x / 3) * 3 + y / 3;

	}

}
