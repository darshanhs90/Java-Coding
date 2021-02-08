package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0051NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(4));
	}

	static boolean solved = false;

	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}
		solved = false;
		List<List<String>> output = new ArrayList<List<String>>();

		backtrack(0, board, output);
		return output;
	}

	public static void backtrack(int row, char[][] board, List<List<String>> output) {
		for (int i = 0; i < board.length; i++) {
			if (canPlace(row, i, board)) {
				placeQueen(row, i, board);
				placeNextQueen(row, board, output);
				if (!solved) {
					removeQueen(row, i, board);
				} else {
					List<String> list = new ArrayList<String>();
					for (int j = 0; j < board.length; j++) {
						String str = Arrays.toString(board[j]);
						str = str.replace("[", "");
						str = str.replace("]", "");
						str = str.replace(",", "");
						str = str.replace(" ", "");
						list.add(str);
					}
					output.add(list);
					solved = false;
					removeQueen(row, i, board);
				}
			}
		}
	}

	public static void placeNextQueen(int row, char[][] board, List<List<String>> output) {
		if (row == board.length - 1) {
			solved = true;
			return;
		} else {
			row += 1;
			backtrack(row, board, output);
		}
	}

	public static void placeQueen(int row, int col, char[][] board) {
		board[row][col] = 'Q';
	}

	public static void removeQueen(int row, int col, char[][] board) {
		board[row][col] = '.';
	}

	public static boolean canPlace(int row, int col, char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == 'Q')
				return false;
			if (board[row][i] == 'Q')
				return false;
		}

		int currRow = row, currCol = col;
		while (currRow >= 0 && currCol >= 0) {
			if (board[currRow][currCol] == 'Q')
				return false;
			currRow--;
			currCol--;
		}

		currRow = row;
		currCol = col;
		while (currRow < board.length && currCol < board.length) {
			if (board[currRow][currCol] == 'Q')
				return false;
			currRow++;
			currCol++;
		}

		currRow = row;
		currCol = col;
		while (currRow >= 0 && currCol < board.length) {
			if (board[currRow][currCol] == 'Q')
				return false;
			currRow--;
			currCol++;
		}

		currRow = row;
		currCol = col;
		while (currRow < board.length && currCol >= 0) {
			if (board[currRow][currCol] == 'Q')
				return false;
			currRow++;
			currCol--;
		}
		return true;
	}
}
