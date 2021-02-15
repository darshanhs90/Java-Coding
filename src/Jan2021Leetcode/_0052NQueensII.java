package Jan2021Leetcode;

import java.util.Arrays;

public class _0052NQueensII {

	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
		System.out.println(totalNQueens(4));
	}

	static int count = 0;
	static boolean success;

	public static int totalNQueens(int n) {
		count = 0;
		success = false;
		char[][] queenArr = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(queenArr[i], '.');
		}
		backtrack(0, queenArr);
		return count;
	}

	public static void backtrack(int row, char[][] queenArr) {
		for (int i = 0; i < queenArr.length; i++) {
			if (canPlace(row, i, queenArr)) {
				placeQueen(row, i, queenArr);
				placeNextRow(row, queenArr);
				if (!success) {
					removeQueen(row, i, queenArr);
				} else {
					success = false;
					removeQueen(row, i, queenArr);
				}
			}
		}
	}

	public static void placeQueen(int row, int col, char[][] queenArr) {
		queenArr[row][col] = 'Q';
	}

	public static void removeQueen(int row, int col, char[][] queenArr) {
		queenArr[row][col] = '.';
	}

	public static void placeNextRow(int row, char[][] queenArr) {
		if (row + 1 == queenArr.length) {
			success = true;
			count++;
		} else {
			backtrack(row + 1, queenArr);
		}
	}

	public static boolean canPlace(int row, int col, char[][] queenArr) {
		int n = queenArr.length;
		// checkRow
		for (int i = 0; i < n; i++) {
			if (queenArr[row][i] != '.')
				return false;
		}

		// checkCol
		for (int i = 0; i < n; i++) {
			if (queenArr[i][col] != '.')
				return false;
		}

		// checkDiagonal
		// lefttop

		int currX = row, currY = col;

		while (currX >= 0 && currY >= 0) {
			if (queenArr[currX][currY] != '.')
				return false;
			currX--;
			currY--;
		}

		// leftbottom

		currX = row;
		currY = col;

		while (currX < n && currY >= 0) {
			if (queenArr[currX][currY] != '.')
				return false;
			currX++;
			currY--;
		}
		// righttop

		currX = row;
		currY = col;

		while (currX >= 0 && currY < n) {
			if (queenArr[currX][currY] != '.')
				return false;
			currX--;
			currY++;
		}
		// rightbottom

		currX = row;
		currY = col;

		while (currX < n && currY < n) {
			if (queenArr[currX][currY] != '.')
				return false;
			currX++;
			currY++;
		}
		return true;
	}

}
