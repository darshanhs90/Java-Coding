package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;
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

	static boolean isSolved;

	public static void solveSudoku(char[][] board) {
		HashMap<Integer, HashSet<Integer>> rowSet = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> colSet = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> boxSet = new HashMap<Integer, HashSet<Integer>>();
		isSolved = false;
		for (int i = 0; i < 9; i++) {
			rowSet.put(i, new HashSet<Integer>());
			for (int j = 0; j < 9; j++) {
				if (!colSet.containsKey(j)) {
					colSet.put(j, new HashSet<Integer>());
				}

				int boxNumber = (i / 3) * 3 + j / 3;
				if (!boxSet.containsKey(boxNumber)) {
					boxSet.put(boxNumber, new HashSet<Integer>());
				}

				if (board[i][j] != '.') {
					rowSet.get(i).add(board[i][j] - '0');
					colSet.get(j).add(board[i][j] - '0');
					boxSet.get(boxNumber).add(board[i][j] - '0');
				}
			}
		}

		backtrack(0, 0, board, rowSet, colSet, boxSet);

		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}

	public static boolean canPlaceNum(int num, int x, int y, HashMap<Integer, HashSet<Integer>> rowSet,
			HashMap<Integer, HashSet<Integer>> colSet, HashMap<Integer, HashSet<Integer>> boxSet) {
		int boxIndex = (x / 3) * 3 + y / 3;
		if (rowSet.get(x).contains(num) || colSet.get(y).contains(num) || boxSet.get(boxIndex).contains(num))
			return false;
		return true;
	}

	public static void placeNumber(int num, int x, int y, char[][] board, HashMap<Integer, HashSet<Integer>> rowSet,
			HashMap<Integer, HashSet<Integer>> colSet, HashMap<Integer, HashSet<Integer>> boxSet) {
		int boxIndex = (x / 3) * 3 + y / 3;
		rowSet.get(x).add(num);
		colSet.get(y).add(num);
		boxSet.get(boxIndex).add(num);
		board[x][y] = (char) (num + '0');
	}

	public static void removeNumber(int num, int x, int y, char[][] board, HashMap<Integer, HashSet<Integer>> rowSet,
			HashMap<Integer, HashSet<Integer>> colSet, HashMap<Integer, HashSet<Integer>> boxSet) {
		int boxIndex = (x / 3) * 3 + y / 3;
		rowSet.get(x).remove(num);
		colSet.get(y).remove(num);
		boxSet.get(boxIndex).remove(num);
		board[x][y] = '.';
	}

	public static void backtrack(int x, int y, char[][] board, HashMap<Integer, HashSet<Integer>> rowSet,
			HashMap<Integer, HashSet<Integer>> colSet, HashMap<Integer, HashSet<Integer>> boxSet) {
		if (board[x][y] == '.') {
			for (int num = 1; num <= 9; num++) {
				if (canPlaceNum(num, x, y, rowSet, colSet, boxSet)) {
					placeNumber(num, x, y, board, rowSet, colSet, boxSet);
					placeNextNumbers(x, y, board, rowSet, colSet, boxSet);

					if (!isSolved)
						removeNumber(num, x, y, board, rowSet, colSet, boxSet);
				}
			}
		} else {
			placeNextNumbers(x, y, board, rowSet, colSet, boxSet);
		}
	}

	public static void placeNextNumbers(int x, int y, char[][] board, HashMap<Integer, HashSet<Integer>> rowSet,
			HashMap<Integer, HashSet<Integer>> colSet, HashMap<Integer, HashSet<Integer>> boxSet) {
		if (x == 8 && y == 8) {
			isSolved = true;
			return;
		} else {
			if (y == 8) {
				backtrack(x + 1, 0, board, rowSet, colSet, boxSet);
			} else {
				backtrack(x, y + 1, board, rowSet, colSet, boxSet);
			}
		}
	}

}
