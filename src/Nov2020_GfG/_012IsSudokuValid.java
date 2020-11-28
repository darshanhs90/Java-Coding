package Nov2020_GfG;

import java.util.Arrays;
import java.util.HashSet;

public class _012IsSudokuValid {

	public static void main(String[] args) {
		System.out.println(isValidSudoku(
				"3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0"));

		System.out.println(isValidSudoku(
				"3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2 9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1 5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0 7"));
	}

	static boolean isValidSudoku(String S) {
		// code here
		char[][] sudoku = new char[9][9];
		String[] sArr = S.split(" ");
		int index = 0;
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				sudoku[i][j] = sArr[index].charAt(0);
				index++;
			}
			System.out.println(Arrays.toString(sudoku[i]));
		}
		HashSet<Character> rowSet = new HashSet<Character>();
		HashSet<Character> colSet = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			rowSet = new HashSet<Character>();
			colSet = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] != '0') {
					if (!rowSet.contains(sudoku[i][j])) {
						rowSet.add(sudoku[i][j]);
					} else {
						return false;
					}

					if (sudoku[j][i] != '0') {
						if (!colSet.contains(sudoku[i][j])) {
							colSet.add(sudoku[i][j]);
						} else {
							return false;
						}
					}
				}
			}
		}

		for (int mult = 0; mult < 3; mult++) {
			HashSet<Character> boxSet = new HashSet<Character>();
			for (int i = mult; i < mult + 3; i++) {
				for (int j = mult; j < mult + 3; j++) {
					if (sudoku[i][j] != '0') {
						if (boxSet.contains(sudoku[i][j]))
							return false;
						boxSet.add(sudoku[i][j]);
					}
				}
			}
		}

		return true;
	}
}
