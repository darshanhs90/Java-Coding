package May2021PrepLeetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		isSolved = false;
		char[][] cArr = new char[n][n];
		for (int i = 0; i < cArr.length; i++) {
			Arrays.fill(cArr[i], '.');
		}
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwSet = new HashSet<Integer>();
		bwSet = new HashSet<Integer>();

		backtrack(0, n, cArr, output);
		return output;
	}

	public static boolean canPlace(int row, int col) {
		if (rowSet.contains(row) || colSet.contains(col) || fwSet.contains(row + col) || bwSet.contains(row - col))
			return false;
		return true;
	}

	public static void placeVal(int row, int col, char[][] cArr) {
		rowSet.add(row);
		colSet.add(col);
		fwSet.add(row + col);
		bwSet.add(row - col);
		cArr[row][col] = 'Q';
	}

	public static void removeVal(int row, int col, char[][] cArr) {
		rowSet.remove(row);
		colSet.remove(col);
		fwSet.remove(row + col);
		bwSet.remove(row - col);
		cArr[row][col] = '.';
	}

	public static void placeNextRow(int row, int n, char[][] cArr, List<List<String>> output) {
		if (row == n - 1) {
			isSolved = true;
		} else {
			backtrack(row + 1, n, cArr, output);
		}
	}

	public static void addOutput(char[][] cArr, List<List<String>> output) {
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
	}

	public static void backtrack(int row, int n, char[][] cArr, List<List<String>> output) {
		for (int i = 0; i < n; i++) {
			if (canPlace(row, i)) {
				placeVal(row, i, cArr);
				placeNextRow(row, n, cArr, output);

				if (!isSolved) {
					removeVal(row, i, cArr);
				} else {
					isSolved = false;
					addOutput(cArr, output);
					removeVal(row, i, cArr);
				}
			}
		}
	}
}
