package May2021Leetcode;

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
		char[][] cArr = new char[n][n];
		for (int i = 0; i < cArr.length; i++) {
			Arrays.fill(cArr[i], '.');
		}
		isSolved = false;
		rowSet = new HashSet<Integer>();
		colSet = new HashSet<Integer>();
		fwSet = new HashSet<Integer>();
		bwSet = new HashSet<Integer>();
		List<List<String>> output = new ArrayList<List<String>>();
		backtrack(0, cArr, output);
		return output;
	}

	public static void backtrack(int row, char[][] cArr, List<List<String>> output) {
		for (int i = 0; i < cArr.length; i++) {
			if (canPlace(row, i)) {
				placeVal(row, i, cArr);
				placeNextVal(row, cArr, output);
				if (isSolved) {
					addToOutput(cArr, output);
					isSolved = false;
					removeVal(row, i, cArr);
				} else {
					removeVal(row, i, cArr);
				}
			}
		}
	}

	public static void addToOutput(char[][] cArr, List<List<String>> output) {
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

	public static void placeNextVal(int row, char[][] cArr, List<List<String>> output) {
		if (row == cArr.length - 1) {
			isSolved = true;
		} else {
			backtrack(row + 1, cArr, output);
		}
	}

	public static void removeVal(int row, int col, char[][] cArr) {
		rowSet.remove(row);
		colSet.remove(col);
		fwSet.remove(row + col);
		bwSet.remove(row - col);
		cArr[row][col] = '.';
	}

	public static void placeVal(int row, int col, char[][] cArr) {
		rowSet.add(row);
		colSet.add(col);
		fwSet.add(row + col);
		bwSet.add(row - col);
		cArr[row][col] = 'Q';
	}

	public static boolean canPlace(int row, int col) {
		if (rowSet.contains(row) || colSet.contains(col) || fwSet.contains(row + col) || bwSet.contains(row - col))
			return false;
		return true;
	}
}
