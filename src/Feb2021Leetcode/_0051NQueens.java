package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0051NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(4));
	}

	static HashSet<Integer> rowSet, colSet, fwDiagSet, bwDiagSet;
	static boolean isSolved;

	public static List<List<String>> solveNQueens(int n) {
		char[][] cArr = new char[n][n];
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwDiagSet = new HashSet<Integer>();
		bwDiagSet = new HashSet<Integer>();
		for (int i = 0; i < cArr.length; i++) {
			Arrays.fill(cArr[i], '.');
		}
		List<List<String>> out = new ArrayList<List<String>>();
		backtrack(0, cArr, out);
		return out;
	}

	public static boolean canPlace(int row, int col) {
		if (rowSet.contains(row) || colSet.contains(col) || fwDiagSet.contains(row + col)
				|| bwDiagSet.contains(row - col))
			return false;
		return true;
	}

	public static void place(int row, int col, char[][] cArr) {
		rowSet.add(row);
		colSet.add(col);
		fwDiagSet.add(row + col);
		bwDiagSet.add(row - col);
		cArr[row][col] = 'Q';
	}

	public static void removeVal(int row, int col, char[][] cArr) {
		rowSet.remove(row);
		colSet.remove(col);
		fwDiagSet.remove(row + col);
		bwDiagSet.remove(row - col);
		cArr[row][col] = '.';
	}

	public static void placeNextRow(int row, char[][] cArr, List<List<String>> output) {
		if (row == cArr.length - 1) {
			isSolved = true;
		} else {
			backtrack(row + 1, cArr, output);
		}
	}

	public static void addToOutput(char[][] cArr, List<List<String>> output) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < cArr.length; i++) {
			String str = Arrays.toString(cArr[i]);
			str = str.replaceAll("\\[", "");
			str = str.replaceAll("]", "");
			str = str.replaceAll(",", "");
			str = str.replaceAll(" ", "");
			list.add(str);
		}
		output.add(list);
	}

	public static void backtrack(int row, char[][] cArr, List<List<String>> output) {
		for (int i = 0; i < cArr.length; i++) {
			if (canPlace(row, i)) {
				place(row, i, cArr);
				placeNextRow(row, cArr, output);

				if (!isSolved) {
					removeVal(row, i, cArr);
				} else {
					isSolved = false;
					addToOutput(cArr, output);
					removeVal(row, i, cArr);
				}
			}
		}
	}
}
