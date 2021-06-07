package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0051NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(4));
	}

	static HashSet<Integer> rowSet, colSet, fwSet, bwSet;
	static boolean isSolved;

	public static List<List<String>> solveNQueens(int n) {
		isSolved = false;
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwSet = new HashSet<Integer>();
		bwSet = new HashSet<Integer>();
		List<List<String>> out = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}

		backtrack(0, n, board, out);
		return out;
	}

	public static boolean canPlace(int row, int col) {
		if (rowSet.contains(row) || colSet.contains(col) || fwSet.contains(row + col) || bwSet.contains(row - col))
			return false;
		return true;
	}

	public static void placeVal(int row, int col, char[][] board) {
		rowSet.add(row);
		colSet.add(col);
		fwSet.add(row + col);
		bwSet.add(row - col);
		board[row][col] = 'Q';
	}

	public static void removeVal(int row, int col, char[][] board) {
		rowSet.remove(row);
		colSet.remove(col);
		fwSet.remove(row + col);
		bwSet.remove(row - col);
		board[row][col] = '.';
	}

	public static void placeNextVal(int row, int n, char[][] board, List<List<String>> out) {
		if (row == n - 1) {
			isSolved = true;
		} else {
			backtrack(row + 1, n, board, out);
		}
	}

	public static void addToOutput(char[][] board, List<List<String>> out) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			String str = Arrays.toString(board[i]);
			str = str.replaceAll(",", "");
			str = str.replaceAll("\\[", "");
			str = str.replaceAll("]", "");
			str = str.replaceAll(" ", "");
			list.add(str);
		}
		out.add(list);
	}

	public static void backtrack(int row, int n, char[][] board, List<List<String>> out) {
		for (int i = 0; i < n; i++) {
			if (canPlace(row, i)) {
				placeVal(row, i, board);
				placeNextVal(row, n, board, out);

				if (!isSolved) {
					removeVal(row, i, board);
				} else {
					addToOutput(board, out);
					isSolved = false;
					removeVal(row, i, board);
				}
			}
		}
	}
}
