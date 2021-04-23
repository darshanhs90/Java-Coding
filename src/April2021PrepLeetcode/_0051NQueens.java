package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0051NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(4));
	}

	static char[][] queensArr;
	static HashSet<Integer> rowSet, colSet, fwDiagSet, bwDiagSet;
	static boolean isSolved;
	static List<List<String>> output;

	public static List<List<String>> solveNQueens(int n) {
		output = new ArrayList<List<String>>();
		if (n <= 0)
			return output;
		isSolved = false;
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwDiagSet = new HashSet<Integer>();
		bwDiagSet = new HashSet<Integer>();
		queensArr = new char[n][n];
		for (int i = 0; i < queensArr.length; i++) {
			Arrays.fill(queensArr[i], '.');
		}
		backtrack(0, n);
		return output;
	}

	public static void backtrack(int currRow, int n) {
		for (int i = 0; i < n; i++) {
			if (canPlace(currRow, i)) {
				placeVal(currRow, i);
				placeNextRow(currRow, n);

				if (!isSolved) {
					removeVal(currRow, i);
				} else {
					isSolved = false;
					removeVal(currRow, i);
				}
			}
		}
	}

	public static void placeNextRow(int row, int n) {
		if (row == n - 1) {
			isSolved = true;
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < queensArr.length; i++) {
				String str = Arrays.toString(queensArr[i]);
				str = str.replaceAll(",", "");
				str = str.replaceAll("\\[", "");
				str = str.replaceAll("]", "");
				str = str.replaceAll(" ", "");
				list.add(str);
			}
			output.add(list);
		} else {
			backtrack(row + 1, n);
		}
	}

	public static void removeVal(int row, int col) {
		rowSet.remove(row);
		colSet.remove(col);
		fwDiagSet.remove(row + col);
		bwDiagSet.remove(row - col);
		queensArr[row][col] = '.';
	}

	public static void placeVal(int row, int col) {
		rowSet.add(row);
		colSet.add(col);
		fwDiagSet.add(row + col);
		bwDiagSet.add(row - col);
		queensArr[row][col] = 'Q';
	}

	public static boolean canPlace(int row, int col) {
		if (rowSet.contains(row) || colSet.contains(col) || fwDiagSet.contains(row + col)
				|| bwDiagSet.contains(row - col))
			return false;
		return true;
	}
}
