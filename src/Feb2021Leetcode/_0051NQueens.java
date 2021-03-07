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

	static boolean isSolved;
	static HashSet<Integer> rowArr, colArr, fwDiag, bwDiag;

	public static List<List<String>> solveNQueens(int n) {
		isSolved = false;
		rowArr = new HashSet<Integer>();
		colArr = new HashSet<Integer>();
		fwDiag = new HashSet<Integer>();
		bwDiag = new HashSet<Integer>();
		List<List<String>> output = new ArrayList<List<String>>();
		char[][] cArr = new char[n][n];
		for (int i = 0; i < cArr.length; i++) {
			Arrays.fill(cArr[i], '.');
		}
		backtrack(0, cArr, output, n);
		return output;
	}

	public static boolean canPlace(int row, int col) {
		if (rowArr.contains(row))
			return false;
		if (colArr.contains(col))
			return false;
		if (fwDiag.contains(row + col))
			return false;
		if (bwDiag.contains(row - col))
			return false;
		return true;
	}

	public static void place(int row, int col, char[][] cArr) {
		rowArr.add(row);
		colArr.add(col);
		fwDiag.add(row + col);
		bwDiag.add(row - col);
		cArr[row][col] = 'Q';
	}

	public static void placeNextRow(int row, int n, char[][] cArr, List<List<String>> output) {
		if (row == n - 1) {
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
			backtrack(row + 1, cArr, output, n);
		}
	}

	public static void removeItem(int row, int col, char[][] cArr) {
		rowArr.remove(row);
		colArr.remove(col);
		fwDiag.remove(row + col);
		bwDiag.remove(row - col);
		cArr[row][col] = '.';
	}

	public static void backtrack(int row, char[][] cArr, List<List<String>> output, int n) {
		for (int i = 0; i < n; i++) {
			if (canPlace(row, i)) {
				place(row, i, cArr);
				placeNextRow(row, n, cArr, output);

				if (!isSolved) {
					removeItem(row, i, cArr);
				} else {
					isSolved = false;
					removeItem(row, i, cArr);
				}
			}
		}
	}
}
