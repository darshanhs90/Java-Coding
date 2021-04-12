package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0051NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(4));
	}

	static boolean isSolved;
	static HashSet<Integer> rowSet, colSet, fwDiagSet, bwDiagSet;

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> output = new ArrayList<List<String>>();
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwDiagSet = new HashSet<Integer>();
		bwDiagSet = new HashSet<Integer>();
		isSolved = false;
		char[][] cArr = new char[n][n];
		for (int i = 0; i < cArr.length; i++) {
			Arrays.fill(cArr[i], '.');
		}
		backtrack(0, cArr, output);
		return output;
	}

	public static void backtrack(int row, char[][] cArr, List<List<String>> output) {
		for (int i = 0; i < cArr.length; i++) {
			if (canPlaceQueen(row, i)) {
				placeQueen(row, i, cArr);
				placeNextRow(row, cArr, output);

				if (!isSolved) {
					removeQueen(row, i, cArr);
				} else {
					isSolved = false;
					removeQueen(row, i, cArr);
				}
			}
		}
	}

	public static void placeNextRow(int row, char[][] cArr, List<List<String>> output) {
		if (row == cArr.length - 1) {
			isSolved = true;
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < cArr.length; i++) {
				String str = Arrays.toString(cArr[i]);
				str = str.replaceAll(",", "");
				str = str.replaceAll("\\[", "");
				str = str.replaceAll("]", "");
				str = str.replaceAll(" ", "");
				list.add(str);
			}
			output.add(list);
		} else {
			backtrack(row + 1, cArr, output);
		}
	}

	public static void placeQueen(int row, int col, char[][] cArr) {
		rowSet.add(row);
		colSet.add(col);
		fwDiagSet.add(row + col);
		bwDiagSet.add(row - col);
		cArr[row][col] = 'Q';
	}

	public static void removeQueen(int row, int col, char[][] cArr) {
		rowSet.remove(row);
		colSet.remove(col);
		fwDiagSet.remove(row + col);
		bwDiagSet.remove(row - col);
		cArr[row][col] = '.';
	}

	public static boolean canPlaceQueen(int row, int col) {
		if (rowSet.contains(row))
			return false;
		if (colSet.contains(col))
			return false;
		if (fwDiagSet.contains(row + col))
			return false;
		if (bwDiagSet.contains(row - col))
			return false;
		return true;
	}
}
